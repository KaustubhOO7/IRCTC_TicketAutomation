<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="ForgotPassword1.css" />
  </head>
  <body>
    <div class="mainLeft">
      <h1>Sirius Ventures</h1>
      <!-- <div class="selectColumn">
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
      </div> -->
    </div>

    <div class="mainRight">
      <h2>Change Password</h2>
      <form action="forgotOTP" method="post">
        <div class="password" id="password">
            <input type="password" placeholder="Enter New Password" name="pass1" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" title="Please enter a valid password. Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit." required />
            <input type="password" placeholder="Re-Enter New Password" name="pass2" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" title="Please enter a valid password. Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit." required />
            <input type="text" name="mobile" placeholder="Enter Mobile Number" pattern="[7-9][0-9]{9}" required>
          <span>Password Does Not Match</span>
          <button type="submit" id="save">Save</button>
        </div>
      </form>

     
    </div>
  </body>
</html>
