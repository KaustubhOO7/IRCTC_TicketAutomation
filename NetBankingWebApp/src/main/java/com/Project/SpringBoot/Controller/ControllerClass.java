package com.Project.SpringBoot.Controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Project.SpringBoot.Model.RegisterPage;
import com.Project.SpringBoot.Model.UsingBank;
import com.Project.SpringBoot.Model.UsingCard;
import com.Project.SpringBoot.Model.UsingMailId;
import com.Project.SpringBoot.Service.ServiceClass;

import jakarta.servlet.http.HttpSession;

import com.Project.SpringBoot.Model.Login;
import com.Project.SpringBoot.Model.PaymentHistory;

@Controller
public class ControllerClass {
	
	@Autowired
	ServiceClass serviceClass;
	
	@Autowired
	HttpSession session;
	
	String amount = null;

	@GetMapping("welcome")
	public String WelcomePage() {
		return "LandingPage.jsp";
	}

	@PostMapping("register")
	public String Register(@ModelAttribute RegisterPage register,Model m) throws Exception 
	{
	    session.setAttribute("userRegistration", register.getEmailid());
	    
	    String email = (String) session.getAttribute("userRegistration");
	    
	    if(email == register.getEmailid())
	    {	
		    session.setAttribute("register", register);
		    
	    	boolean isEmail = serviceClass.checkMail(register.getEmailid());
	    	if (isEmail == false) {
	    		return "ImageSubmit.jsp";
	    	}
	    	
	    	return "EmailExists.jsp";	    	
	    }
	    
	    return "LandingPage.jsp";
	}

	@PostMapping("signatureImage")
	public String Image(@RequestParam("signature") MultipartFile file,Model m) throws Exception 
	{
		String email = (String) session.getAttribute("userRegistration");	
		RegisterPage register = (RegisterPage) session.getAttribute("register");
		
		if(email == register.getEmailid() && register.getEmailid()!= null)
		{
			String name = serviceClass.saveImageIntoDrive(file);
			session.setAttribute("name", name);
			
			m.addAttribute("imageFile", name);
			
			Thread.sleep(3000);
			
			return "ImageSubmitPreview.jsp";
		}
		return "LandingPage.jsp";
	
	}

	@PostMapping("password")
	public String Password(@RequestParam("pass1") String pass1, @RequestParam("pass2") String pass2,Model m) throws Exception 
	{
		String email = (String) session.getAttribute("userRegistration");
		RegisterPage register = (RegisterPage) session.getAttribute("register");
		String name = (String) session.getAttribute("name");
		
		
		if (pass1.equals(pass2)) 
		{
			String generateUserId = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
			String generateAccountNumber = RandomStringUtils.randomNumeric(16);
			
			serviceClass.save(register, generateUserId ,generateAccountNumber);
			
			serviceClass.saveImageData(name, serviceClass.getUserId(email));
				
			serviceClass.savePassword(serviceClass.getUserId(email), pass1);
			m.addAttribute("key", serviceClass.getUserId(email));
			
			session.removeAttribute("userRegistration");
			session.removeAttribute("register");
			session.removeAttribute("name");
			
			return "ThankYouPage.jsp";
		}
		
		session.removeAttribute("userRegistration");
		session.removeAttribute("register");
		session.removeAttribute("name");
		
		return "ErrorPassword.jsp";
	}
	
	@GetMapping("loginCheck")
	public String login() throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
			if( serviceClass.loginCheck(email)==false)
			{			
				return "LoginPage.jsp";
				
			}
			else
			{
				
				return "redirect:/dashboard";
			}
			
		} 

	@GetMapping("Login")
	public String Login(@ModelAttribute Login login, Model m)throws Exception 
	{	
		boolean bool = serviceClass.checkDetails(login);
		
		if (bool == true) 
		{
			if(serviceClass.loginCheck(login.getEmailid())==false)
			{
                session.setAttribute("currentUser", login.getEmailid());
			    
				serviceClass.insertIntoCurrentUserSession(login.getEmailid(),"LoggedIn");
							
				String name = serviceClass.getFullName(login.getEmailid());
 				m.addAttribute("name", name);
				
				String balance = serviceClass.getBalance(login.getEmailid());
				m.addAttribute("balance", balance);
				
				List<PaymentHistory> history = serviceClass.gethistory(login.getEmailid());
				
				for (int i = 1; i <= 5 && i <= history.size(); i++) {
					m.addAttribute("data" + i, history.get(i - 1));
				}
				
				List<String> list = new ArrayList<>();
				list = serviceClass.checkMoneyRequest(login.getEmailid());
				
				if(list.size() != 0)
				{
					m.addAttribute("requester", list.get(0));
					m.addAttribute("amount", list.get(1));
					
					return "OpeningPageMoneyRequest.jsp";
				}
				
				 return "OpeningPage.jsp";
			}
			    
				return "redirect:/dashboard";
			
		} 
		else 
		{
			return "LoginError.jsp";
		}

	}

	@GetMapping("dashboard")
	public String showDashboard(Model m) throws Exception 
	{	
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if (email != null) 
			{
				String balance = serviceClass.getBalance(email);
				m.addAttribute("balance", balance);
				
				List<PaymentHistory> history = serviceClass.gethistory(email);
				
				for (int i = 1; i <= 5 && i <= history.size(); i++) 
				{
					m.addAttribute("data" + i, history.get(i - 1));
				}
			}
			return "OpeningPage.jsp";			
		}
		
		return "LoginPage.jsp";
		
	}

	@GetMapping("signout")
	public String signout() throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
	
		serviceClass.loggingOut(email);
		session.removeAttribute("currentUser");

		return "LandingPage.jsp";
	}

	@GetMapping("SendMoney")
	public String sendMoney(Model m) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			return "SendMoney.jsp";			
		}
		return "LoginPage.jsp";
	}

	@PostMapping("usingMailId")
	public String usingMailId(@ModelAttribute UsingMailId usingMailId, Model m)throws Exception 
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if(serviceClass.getBalance(email)==null )
			{
				return "LowBalance.jsp";
			}
			else
			{
				int amount = Integer.parseInt(serviceClass.getBalance(email));
				int enteredAmount = Integer.parseInt(usingMailId.getAmount());
				
				if (enteredAmount <= amount) 
				{
					if(serviceClass.savePaymentUsingMail(usingMailId, email)==true)
					{
						String remark = "Using Email Id";
						serviceClass.insertingIntoPayments(usingMailId.getMailId(), email, usingMailId.getAmount(),remark);
						return "AmountSentSuccess.jsp";
					}
					
					m.addAttribute("type","Email Id");
					return "UserNotExist.jsp";
				}
				
			}
			
			return "LowBalance.jsp";
			
		}
		
		return"LoginPage.jsp";

	}

	@PostMapping("usingCard")
	public String usingCard(@ModelAttribute UsingCard usingCard, Model m) throws Exception 
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if(serviceClass.isCardHolder(usingCard.getCard())==true)
			{
				
				if(serviceClass.getBalance(email)==null)
				{
					return "LowBalance.jsp";
				}
				else
				{
					int amount = Integer.parseInt(serviceClass.getBalance(email));
					int enteredAmount = Integer.parseInt(usingCard.getAmount());
					
					if (enteredAmount <= amount) 
					{
						this.amount = usingCard.getAmount();
						return "SendMoneyNext.jsp";
					}
					
					return "LowBalance.jsp";	
				}
			}
			
			m.addAttribute("type","Card Number");
			return "UserNotExist.jsp";
			
		}
		
		return "LoginPage.jsp";
		
	}
	
	@GetMapping("usingCardNext")
	public String usingCardNext(@RequestParam("name") String receiverName, @RequestParam("accountNo") String receiverAccountNo, @RequestParam("ifsc") String receiverIfsc, Model m) throws Exception
	{	
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			m.addAttribute("receiverName1", receiverName);
			m.addAttribute("receiverAccountNo1", receiverAccountNo);
			m.addAttribute("receiverIfsc1", receiverIfsc);
			
			
			String otp = RandomStringUtils.randomNumeric(6);
			serviceClass.sendOtp(otp,"",email);
			return "SendMoneyNextOtp.jsp";			
		}
		return "LoginPage.jsp";
	}
	
	@GetMapping("otpMatchViaCard")
	public String otpMatchViaCard(@RequestParam("otp") String otp, @RequestParam("receiverName") String receiverName, @RequestParam("receiverAccountNo") String receiverAccountNo, @RequestParam("receiverIfsc") String receiverIfsc, Model m) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if(serviceClass.checkOtpViaCard(otp) == true) 
			{ 
				String receiverEmail = serviceClass.checkAccountNumber(receiverAccountNo);
				if(receiverEmail != null)
				{
					String remark = "Using Bank Transfer via Debit Card";
					serviceClass.savePaymentUsingBank(receiverName,receiverAccountNo,receiverIfsc,amount,email);
					serviceClass.insertingIntoPayments(receiverEmail,email,amount,remark);
					return "AmountSentSuccess.jsp";
				}
				
				m.addAttribute("type", "Account Number");
				return "UserNotExist.jsp";
				
			}
			
			return"OtpNotMatched.jsp";
			
		}
		
		return "LoginPage.jsp";
	}

	@PostMapping("usingBank")
	public String usingBank(@ModelAttribute UsingBank usingBank,Model m) throws Exception 
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if(serviceClass.getBalance(email)==null)
			{
				return "LowBalance.jsp";
			}
			else
			{
				
				int amount = Integer.parseInt(serviceClass.getBalance(email));
				int enteredAmount = Integer.parseInt(usingBank.getAmount());
				
				if (enteredAmount <= amount) 
				{
					String receiverEmail = serviceClass.checkAccountNumber(usingBank.getAccountNo());
					if(receiverEmail != null)
					{
						String remark = "Using Bank Transfer";
						serviceClass.savePaymentUsingBank(usingBank.getName(),usingBank.getAccountNo(),usingBank.getIfsc(),usingBank.getAmount(),email);
						serviceClass.insertingIntoPayments(receiverEmail,email,usingBank.getAmount(),remark);
						return "AmountSentSuccess.jsp";
					}
					
				}
				return "LowBalance.jsp";
			}
		}
		
		return "LoginPage.jsp";
		
	}
	
	@GetMapping("transaction")
	public String showTransaction(Model m) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			List<PaymentHistory> transaction = serviceClass.showAllTransaction(email);
			m.addAttribute("transactions", transaction);
			return "Transaction.jsp";
			
		}
		
		return "LoginPage.jsp";
	}
	
	@GetMapping("settings")
	public String showSettings(Model m) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			m.addAttribute("email",email);
			
			String[] arr = serviceClass.getdetail(email);
			m.addAttribute("arr",arr);		
			return "Settings.jsp";
			
		}
		
		return "LoginPage.jsp";
	}
	
	@PostMapping("sendOTP")
	public String sendOTP(@RequestParam("pass1") String pass1,@RequestParam("pass2") String pass2,Model m) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if(pass1.equals(pass2))
			{
				String otp = RandomStringUtils.randomNumeric(6);
				serviceClass.sendOtp(otp,pass1,email);
				
				return "EnterOtp.jsp";
			}
			
			return "ChangePasswordError.jsp";			
		}
		return "LoginPage.jsp";
	}
	
	@GetMapping("otpMatch")
	public String otpMatching(@RequestParam("otp") String otp,Model m) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			String name = serviceClass.getFullName(email);
			m.addAttribute("name", name);
			
			if(serviceClass.checkOTP(otp,email) == true) return "PasswordSuccess.jsp";
			
			return"OtpNotMatched.jsp";	
		}
		return "LoginPage.jsp";
	}
	
	@PostMapping("forgotOTP")
	public String forgotOTP(@RequestParam("pass1") String pass1,@RequestParam("pass2") String pass2,@RequestParam("mobile") String mobile) throws Exception
	{
			if(pass1.equals(pass2))
			{
				String otp = RandomStringUtils.randomNumeric(6);
				serviceClass.forgotOtp(otp,pass1,mobile);
				
				return "ForgotPassword2.jsp";
			}
			
			return "ForgotPassword1.jsp";			
		
	}
	
	@GetMapping("forgotOtpMatch")
	public String forgotOtpMatching(@RequestParam("otp") String otp) throws Exception
	{
			if(serviceClass.checkForgotOTP(otp) == true) return "ForgotPassword4.jsp";
			
			return"ForgotPassword3.jsp";
			
	}
	
	@GetMapping("sendRequest")
	public String sendRequest(@RequestParam("remitter") String remitter, @RequestParam("amount") String amount) throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		if(serviceClass.loginCheck(email)==true)
		{
			serviceClass.inserIntoRequestMoney(email,amount,remitter);
			Thread.sleep(3000);
			return "redirect:/dashboard";
		}
		return "LoginPage.jsp";
	}
	
	@PostMapping("declineMoney")
	public String declineMoney() throws Exception
	{
		String email = (String) session.getAttribute("currentUser");
		
		if(serviceClass.loginCheck(email)==true)
		{
			serviceClass.deleteMoneyRequest(email);
			return "redirect:/dashboard";
		}
		return "LoginPage.jsp";
	}

}
