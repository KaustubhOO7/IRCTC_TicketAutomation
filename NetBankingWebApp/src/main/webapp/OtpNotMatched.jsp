<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="OtpNotMatched.css" />
  </head>
  <body>
    <div class="mainLeft">
      <h1>Sirius Ventures</h1>
      <div class="selectColumn">
        <a href="dashboard">
          <div class="dashboard">Dashboard</div>
        </a>
        <a href="transaction">
          <div class="transaction">Transaction</div>
        </a>
        <a href="SendMoney">
          <div class="payment">Payments</div>
        </a>
        <a href="settings">
          <div class="settings">Settings</div>
        </a>
        <a href="signout">
          <div class="signout">Sign Out</div>
        </a>
        <div class="name">Welcome ${name}</div>
      </div>
    </div>

    <div class="mainRight">
      <h2>Change Password</h2>
      <form action="otpMatch" method="get">
        <div class="password" id="password">
          <input type="password" id="otp" placeholder="Enter OTP" name="otp"/>
          <p id="message">OTP does not Match<br>ReEnter OTP.</p>
          <button type="submit" id="submit">Submit</button>
        </div>
      </form>

     
    </div>
  </body>
</html>
