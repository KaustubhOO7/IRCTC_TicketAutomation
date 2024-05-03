<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="Settings.css">
</head>
<body>
    <div class="mainLeft">
        <h1>Sirius Ventures</h1>
        <div class="selectColumn">
            <a href="dashboard">
                <div class="dashboard">
                    Dashboard
                </div>
            </a>
            <a href="transaction">
                <div class="transaction">
                    Transaction
                </div>
            </a>
            <a href="SendMoney">
                <div class="payment">
                    Payments
                </div>
            </a>
            <a href="settings">
                <div class="settings">
                    Settings
                </div>
            </a>
            <a href="signout">
                <div class="signout">
                    Sign Out
                </div>
            </a>
            <div class="name">
                Welcome ${name}
             </div>
        </div>
    </div>

    <div class="mainRight">
        <h2>Settings</h2>
        <div class="profile" onclick="showData1()">
            <h3>Profile Information</h3>
            <div class="profile-sub" id="profile-sub" style="display: none;">
                <span id="name">Name :- ${name}</span>
                <span id="email">Email Address :- ${email}</span>
                <span id="phone">Phone Number :- ${arr[0]}</span>
                <span id="address">Mailing Address :- ${arr[1]}</span>
            </div>
        </div>

        <div class="password" onclick="showData2()">
            <h3>Password Management</h3>
            <div class="password-sub" id="password-sub" style="display: none;">
                <a href="ChangePassword.jsp"><span id="pass">Change Password</span></a>
                <ul>
                    <li>Contain at least one digit.</li>
                    <li>Contain at least one lowercase letter.</li>
                    <li>Contain at least one uppercase letter.</li>
                    <li>Have a minimum length of 8 characters.</li>
                  </ul>
            </div>
        </div>
            
        </div>
    </div>
    
    <script>
        function showData1()
        {
            let show = document.getElementById("profile-sub");
            show.style.display = (show.style.display === "none") ? "block" : "none";
        }

        function showData2()
        {
            let show = document.getElementById("password-sub");
            show.style.display = (show.style.display === "none") ? "block" : "none";
        }

    </script>
</body>
</html>