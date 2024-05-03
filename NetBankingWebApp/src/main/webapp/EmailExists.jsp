<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="EmailExists.css">
</head>
<body>
    <div class="main">
        <img src="Images/background.png">
        <h2>
            <b>Sirius Ventures</b>
         </h2>
        <h1>Account Registration</h1>

        <div class="classForm">

            <p class="head1">
                Account Information <br>
                --------------------------------------------------------------------------------------------------
            </p>

            <form action="register" method="post" id="form1">
           
                <p class="p1">Please Specify Account Type :- </p>
               
               <select name="accnt" class="specify">
                <option>Please Specify</option>
                 <option value="Savings" ${register.accnt == "Savings" ? " selected " : "" } >Savings</option>
                 <option value="Current" ${register.accnt == "Current" ? " selected " : "" } >Current</option>
               </select>

              <p class="p2">Currency Type :- </p>
               
               <select name="curr" class="currency">
                <option>Please Specify</option>
                 <option value="INR" ${register.curr == "INR" ? " selected " : "" } >INR</option>
                 <option value="USD" ${register.curr == "USD" ? " selected " : "" } >USD</option>
                 <option value="EURO" ${register.curr == "EURO" ? " selected " : "" } >EURO</option>
                 <option value="YEN" ${register.curr == "YEN" ? " selected " : "" } >YEN</option>
                 <option value="RUBLE" ${register.curr == "RUBLE" ? " selected " : "" } >RUBLE</option>
               </select>
                  

               <p class="head2">
                 Personal Information<br>
                --------------------------------------------------------------------------------------------------
               </p>

               <div class="name">
                <label>Name :-</label>
                <input type="text" name="first" id="namedata1" value="${register.first}" placeholder="Enter First Name"/>

                <input type="text" name="middle" id="namedata2" value="${register.middle}" placeholder="Enter Middle Name"/>

                <input type="text" name="last" id="namedata3" value="${register.last}" placeholder="Enter Last Name"/>
               </div>

               <div class="phone">
                <label>Phone Number :-</label>
                <input type="text" name="phone" value="${register.phone}" placeholder="Enter Phone Number"/>

               </div>

               <div class="dob">
                <label>Enter Date of Birth :-</label>
                <input type="date" name="dob" value="${register.dob}"/>

               </div>

               <div class="add">
                <label>Residential Address :-</label>
                <input type="text" name="add1" value="${register.add1}" id="first" placeholder="Enter Address Line 1"/>
                <input type="text" name="add2" value="${register.add2}" id="second" placeholder="Enter Address Line 2"/>
                <input type="text" name="city" value="${register.city}" id="third" placeholder="Enter City"/>
                <input type="text" name="state" value="${register.state}" id="fourth" placeholder="Enter State"/>
                <input type="text" name="zip" value="${register.zip}" id="fifth" placeholder="Enter Pin Code"/>
               </div>

               <div class="occ">
                <label>Occupation :-</label>
                <input type="text" name="occ" value="${register.occ}" placeholder="Enter Occupation"/>

               </div>

               <p class="Gender">Gender :-</p>
               <div class="gender">
                <label for="male">Male</label>
                <input type="radio" name="gender" id="male" value="male" ${register.gender == 'male' ? " checked " : '' } >
                <label for="female">Female</label>
                <input type="radio" name="gender" id="female" value="female" ${register.gender == 'female' ? " checked " : '' }>
                <label for="other">Other</label>
                <input type="radio" name="gender" id="other" value="other" ${register.gender == 'other' ? " checked " : '' }>
               </div>

               <div class="mailid">
                <p>Email :- </p>
                <input type="email" name="emailid" placeholder="Enter Your Email Address" pattern="^[a-z\d._%\-]+@[a-z]+\.[a-z]{3,}$" title="Please enter a valid email address (e.g., example@example.com)" required />
                <p id="exists">Email Already Exists !</p>
               </div>
               
               
               <p class="head1">
                --------------------------------------------------------------------------------------------------
               </p>

               <p class="agree">
                <i>By signing this form, I acknowledge that the information I've given in this form is accurate and I agree all <br> the terms and conditions.</i>
               </p>

                <button type="submit" id="submit">SAVE</button>
                <button type="reset" id="clear">CLEAR</button>
                
            </form>

            
            

        </div>
        
    </div>

    
</body>
</html>