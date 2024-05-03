<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="SendMoneyNextOtp.css">
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

        <form action="otpMatchViaCard" method="get">
            <div class="accountPayment" id="accountPayment">
                <input type="text" placeholder="Receiver's Name" name="receiverName" id="name" value="${receiverName1}" required />
                <input type="text" placeholder="Receiver's Account Number" name="receiverAccountNo" id="accountNo" value="${receiverAccountNo1}" pattern="[0-9]*" title="Please enter numbers only" required />
                <input type="text" placeholder="Receiver's IFSC" name="receiverIfsc" id="ifsc" value="${receiverIfsc1}" required />
                <input type="text" placeholder="Enter OTP, Sent to Your Number" name="otp" id="otp" required />
                <button type="submit" id="send">Send</button>
            </div>
        </form>
        
    </div>
</body>
</html>