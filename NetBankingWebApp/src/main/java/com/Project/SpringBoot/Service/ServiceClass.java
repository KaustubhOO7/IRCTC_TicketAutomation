package com.Project.SpringBoot.Service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Project.SpringBoot.Model.Login;
import com.Project.SpringBoot.Model.OtpGenerator;
import com.Project.SpringBoot.Model.RegisterPage;
import com.Project.SpringBoot.Model.UsingMailId;
import com.Project.SpringBoot.Model.PaymentHistory;
import com.Project.SpringBoot.Repository.ProjectDatabase;


@Service
public class ServiceClass 
{
	@Autowired
	ProjectDatabase projectDatabase;
	
	String updatedPassword = null;
	String mobile = null;
	
	public void insertIntoCurrentUserSession(String userMail, String status) throws Exception
	{
	   String sql = "insert into currentUserSession values('"+userMail+"','"+status+"')";
	   projectDatabase.s.executeUpdate(sql);
	}
	
	public boolean loginCheck(String userMail) throws Exception
	{
		String sql = "select * from currentUserSession where currentMailId = '"+userMail+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			if(rs.getString("userStatus").equals("LoggedIn")) return true;
		}
	
		return false;
	}
	
	public void loggingOut(String userMail) throws Exception
	{
		String sql = "delete from currentUserSession where currentMailId = '"+userMail+"'";
	    projectDatabase.s.executeUpdate(sql);
	}
	
	 public void save(RegisterPage register,String id, String accountNumber) throws Exception
	   {
		     
		      String sql = "insert into registration values('"+id+"','"+register.getAccnt()+"','"+register.getCurr()+"','"+register.getFirst()+"','"+register.getMiddle()+"','"+register.getLast()+"','"+register.getPhone()+"','"+register.getDob()+"','"+register.getAdd1()+"','"+register.getAdd2()+"','"+register.getCity()+"','"+register.getState()+"','"+register.getZip()+"','"+register.getOcc()+"','"+register.getGender()+"','"+register.getEmailid()+"','"+accountNumber+"')";
			  projectDatabase.s.executeUpdate(sql);
	   }
	 
	 public boolean checkMail(String emailid) throws Exception
	 {
	        String email=null;	 
			String sql = "select * from registration where email = '"+emailid+"'";
			ResultSet rs = projectDatabase.s.executeQuery(sql);
			while(rs.next())
			{
				email=rs.getString("email");
			}
			
			if(email == null) return false;
			
			return true;
		}
	 
	 
	 public void saveImageData(String image,String id) throws Exception
	 {
		  String sql = "insert into signature values('"+id+"','"+image+"')";
		  projectDatabase.s.executeUpdate(sql);
	 }

	 public String saveImageIntoDrive(MultipartFile file) throws Exception
			 {
		    
		    String name = file.getOriginalFilename();
		    InputStream is = file.getInputStream();
		    String uploadPath = "C:/Users/Raghav/Documents/Spring4/NetBankingWebApp/src/main/webapp/UserImages/";
			FileOutputStream output = new FileOutputStream(uploadPath+name);
			
			byte[] data = new byte[is.available()];
            is.read(data);
            output.write(data);

			output.close();
			
			return name;
		   
			 }
	 

	public void savePassword(String id, String pass1) throws Exception
	{
		String sql = "insert into password values('"+id+"','"+pass1+"')";
		projectDatabase.s.executeUpdate(sql);
		
	}



	public boolean checkDetails(Login login) throws Exception
	{
		String email=null;
		String password=null;
		String sql = "select * from registration r,password p where r.email='"+login.getEmailid()+"' and p.password='"+login.getPassword()+"'";
	    ResultSet rs = projectDatabase.s.executeQuery(sql);
	    
	    while(rs.next())
	    {
	    	email=rs.getString("email");
	    	password=rs.getString("password");
	    }
		
	    if(email != null && password != null)
	    {
	    	return true;
	    }
	    
	    return false;
	}


   public String getBalance(String email) throws Exception
   {
	   String balance=null;
	   String sql = "select (select ifnull(sum(amount),0) from payments where status='CR' and emailId = '"+email+"') - (select ifnull(sum(amount),0) from payments where status='DR' and emailId = '"+email+"') as Net from payments limit 1";
	   ResultSet rs = projectDatabase.s.executeQuery(sql);
	   while(rs.next())
	   {
		   balance = rs.getString("Net");
	   }
   
	   return balance;
   }

	public List<PaymentHistory> gethistory(String Emailid) throws Exception
	{
		List<PaymentHistory> history = new ArrayList<>();
		
	    String sql = "select * from payments where emailId = '"+Emailid+"' order by date desc limit 5";
	    ResultSet rs = projectDatabase.s.executeQuery(sql);
	    while(rs.next())
	    {
	    	PaymentHistory paymentHistory = new PaymentHistory();
	    
	    	paymentHistory.setAmount(rs.getString("amount"));
	    	paymentHistory.setDate(rs.getString("date"));
	    	paymentHistory.setStatus(rs.getString("status"));
	    	
	    	history.add(paymentHistory);
	    	
	    }
	    
		return history;
	}
	

	public boolean savePaymentUsingMail(UsingMailId usingMailId, String senderMail) throws Exception
	{
		String email=null;
		String sql = "select * from registration where email = '"+usingMailId.getMailId()+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			email = rs.getString("email");
		}
		
		if(email != null)
		{
			sql = "insert into usingmail values('"+usingMailId.getMailId()+"','"+usingMailId.getAmount()+"','"+senderMail+"')";
			projectDatabase.s.executeUpdate(sql);
			return true;
		}
		
	    return false;
		
	}

	
	public void savePaymentUsingBank(String receiverName, String receiverAccountNo, String receiverIfsc, String amount, String userMail) throws Exception
	{
		
		String sql = "insert into usingbank values('"+receiverName+"','"+receiverAccountNo+"','"+receiverIfsc+"','"+amount+"','"+userMail+"')";
		projectDatabase.s.executeUpdate(sql);
	}

	public String getUserId(String userMail) throws Exception
	{
		String val = null;
	    String sql = "select * from registration where email = '"+userMail+"'";
	    ResultSet rs = projectDatabase.s.executeQuery(sql);
	    
	    while(rs.next())
	    {
	    	val = rs.getString("id");
	    }
		return val;
	}

	public void insertingIntoPayments(String receiverMail,String senderMail,String amount,String remark) throws Exception
	{
		 LocalDate today = LocalDate.now();
		 Date date = Date.valueOf(today);
		 String sql = "insert into payments values('"+amount+"','"+date+"','"+"DR"+"','"+senderMail+"','"+remark+"')";	
		 projectDatabase.s.executeUpdate(sql);
		 
		 sql = "insert into payments values('"+amount+"','"+today+"','"+"CR"+"','"+receiverMail+"','"+remark+"')";
		 projectDatabase.s.executeUpdate(sql);
		
	}
	
	public String getFullName(String userMail) throws Exception
	{
		String name = null;
		String sql = "select * from registration where email = '"+userMail+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		
		while(rs.next())
		{
			name = rs.getString("firstName");
			name = name + " " + rs.getString("lastName");
		}
		
		return name;
	}

	public List<PaymentHistory> showAllTransaction(String userMail) throws Exception
	{
        List<PaymentHistory> history = new ArrayList<>();
		
	    String sql = "select * from payments where emailId = '"+userMail+"' order by date desc";
	    ResultSet rs = projectDatabase.s.executeQuery(sql);
	    while(rs.next())
	    {
	    	PaymentHistory paymentHistory = new PaymentHistory();
	    
	    	paymentHistory.setAmount(rs.getString("amount"));
	    	paymentHistory.setDate(rs.getString("date"));
	    	paymentHistory.setStatus(rs.getString("status"));
	    	
	    	history.add(paymentHistory);
	    	
	    }
	    
		return history;
	}

	public String[] getdetail(String userMail) throws Exception
	{
		String[] arr = new String[2];
		String sql = "select * from registration where email = '"+userMail+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		
		while(rs.next())
		{
			String phone = rs.getString("phoneNo");
			String address = rs.getString("street")+","+rs.getString("landmark")+","+rs.getString("city")+","+rs.getString("state");
			arr[0]=phone;
			arr[1]=address;
		}
		
		return arr;
	}

	public void sendOtp(String otp, String pass1, String userMail) throws Exception
	{
		String number = null;
		updatedPassword = pass1;
		
		String sql = "select * from registration where email = '"+userMail+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			number = rs.getString("phoneNo");
		}
		
		OtpGenerator otpGenerator = new OtpGenerator();
		otpGenerator.sendSMS(otp, number);
		
		sql = "insert into otp values('"+otp+"')";
		projectDatabase.s.executeUpdate(sql);
		
	}
	
	public boolean checkOTP(String otp, String userMail) throws Exception
	{
		boolean bool = false;
		String id = null;
		
		String sql = "select * from otp";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			if(otp.equals(rs.getString("otp")))
			{
				bool = true;
				break;
			}
		}
		
		if(bool == true)
		{
			sql = "select * from registration where email = '"+userMail+"'";
			System.out.println(userMail);
			ResultSet rs1 = projectDatabase.s1.executeQuery(sql);
			while(rs1.next())
			{
				id = rs1.getString("id");
			}
			System.out.println("id "+id+" password "+updatedPassword);
			sql = "update password set password = '"+updatedPassword+"' where id = '"+id+"'";
			projectDatabase.s1.executeUpdate(sql);
			
			sql="delete from otp where otp = '"+otp+"'";
			projectDatabase.s1.executeUpdate(sql);
		}
		
		return bool;
	}
	
	public void forgotOtp(String otp, String pass1, String mobile) throws Exception
	{
		this.mobile = mobile;
		updatedPassword = pass1;
		
		OtpGenerator otpGenerator = new OtpGenerator();
		otpGenerator.sendSMS(otp, mobile);
		
		String sql = "insert into otp values('"+otp+"')";
		projectDatabase.s.executeUpdate(sql);
		
	}
	
	public boolean checkForgotOTP(String otp) throws Exception
	{
		boolean bool = false;
		String id = null;
		
		String sql = "select * from otp";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			if(otp.equals(rs.getString("otp")))
			{
				bool = true;
				break;
			}
		}
		
		if(bool == true)
		{
			sql = "select * from registration where phoneNo = '"+mobile+"'";
			System.out.println(mobile);
			ResultSet rs1 = projectDatabase.s1.executeQuery(sql);
			while(rs1.next())
			{
				id = rs1.getString("id");
			}
			System.out.println("id "+id+" password "+updatedPassword);
			sql = "update password set password = '"+updatedPassword+"' where id = '"+id+"'";
			projectDatabase.s1.executeUpdate(sql);
			
			sql="delete from otp where otp = '"+otp+"'";
			projectDatabase.s1.executeUpdate(sql);
		}
		
		return bool;
	}

	public boolean isCardHolder(String card) throws Exception
	{
		String sql = "select * from debitCardHolder";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			if(card.equals(rs.getString("cardNo")))
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean checkOtpViaCard(String otp) throws Exception
	{		
		String sql = "select * from otp";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			if(otp.equals(rs.getString("otp")))
			{
				sql="delete from otp where otp = '"+otp+"'";
				projectDatabase.s1.executeUpdate(sql);
				
				return true;
			}
		}
		
		return false;
	}

	public String checkAccountNumber(String receiverAccountNo) throws Exception
	{
		String sql = "select * from registration where accountNumber = '"+receiverAccountNo+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			receiverAccountNo.equals(rs.getString("accountNumber"));
			return rs.getString("email");
		}
		return null;
	}

	public String getPassword(String userMail) throws Exception
	{
		String id = getUserId(userMail);
		String sql = "select * from password where id = '"+id+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			String password = rs.getString("password");
			return password;
			
		}
		
		return null;
	}

	public void inserIntoRequestMoney(String email, String amount, String remitter) throws Exception
	{
		String sql = "insert into requestMoney values('"+email+"','"+amount+"','"+remitter+"')";
		projectDatabase.s.executeUpdate(sql);
	}

	public List<String> checkMoneyRequest(String emailid) throws Exception
	{
		List<String> list = new ArrayList<>();
         		
		String sql = "select * from requestMoney where senderEmail = '"+emailid+"'";
		ResultSet rs = projectDatabase.s.executeQuery(sql);
		while(rs.next())
		{
			list.add(rs.getString("receiverEmail"));
			list.add(rs.getString("amount"));
			break;
		}
		
		return list;
		
	}

	public void deleteMoneyRequest(String email) throws Exception
	{
		String sql = "delete from requestMoney where senderEmail = '"+email+"'";
		projectDatabase.s.executeUpdate(sql);
	}

	

	

	

	

	

		
}  

