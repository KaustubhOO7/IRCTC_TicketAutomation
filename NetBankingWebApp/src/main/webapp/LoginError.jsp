<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="LoginError.css">
</head>
<body>
   
<div class="container" id="container">
	<div class="form-container sign-in-container">
		<form action="Login" method="get">
			<h2 id="head"> 
				<b>Sirius Ventures</b>
			 </h2>
			<h1>Sign in</h1>
			<input type="email" placeholder="Email" name="emailid" pattern="^[a-z\d._%\-]+@[a-z]+\.[a-z]{3,}$" title="Please enter a valid email address (e.g., example@example.com)" required/>
			<input type="password" placeholder="Password" name="password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" title="Please enter a valid password. Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit." required/>
			<p id="para">Wrong Email Id or Password</p>
			<a href="ForgotPassword0.jsp">Forgot your password?</a>
			<button type="submit">Sign In</button>
		</form>
		
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p id="detail">Enter your details and lets get Started.</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>
