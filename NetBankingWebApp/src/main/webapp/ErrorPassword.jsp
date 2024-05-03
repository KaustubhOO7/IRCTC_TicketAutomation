<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="ErrorPassword.css">
</head>
<body>

    <div class="main">
        <img src="Images/background.png">
        <h2>
            <b>Sirius Ventures</b>
         </h2>
        
         <form action="password" method="post" id="form">
            <div class="sign">
                <p>Create Password</p>
                <input type="password" name="pass1" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" title="Please enter a valid password. Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit." required />
                <p>Confirm Password</p>
                <input type="password" name="pass2" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" title="Please enter a valid password. Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit." required />
                 <p id="pass">Password Does Not Match</p>
                <button type="submit">SAVE</button>
            </div>
        </form>

    </div>
    
</body>
</html>
