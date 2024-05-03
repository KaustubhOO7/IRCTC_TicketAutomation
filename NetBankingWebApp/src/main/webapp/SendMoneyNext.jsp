<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="SendMoneyNext.css">
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
        <h2 id="payment">Payments</h2>

        <form action="usingCardNext" method="get">
            <div class="accountPayment" id="accountPayment">
                <input type="text" placeholder="Receiver's Name" name="name" id="name" required />
                <input type="text" placeholder="Receiver's Account Number" name="accountNo" id="accountNo" pattern="[0-9]*" title="Please enter numbers only" required />
                <input type="text" placeholder="Receiver's IFSC" name="ifsc" id="ifsc" required />
                <button type="submit" id="sendOTP">Send OTP</button>
            </div>
        </form> 
    </div>
</body>
</html>