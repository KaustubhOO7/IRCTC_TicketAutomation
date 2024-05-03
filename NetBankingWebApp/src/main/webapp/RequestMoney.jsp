<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="RequestMoney.css">
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
        <div class="temp">
            <div class="requestMoney">
                <form action="sendRequest" method="get" onsubmit="return showAlert1()">
                    <input type="text" name="remitter" id="mailId" placeholder="Enter Remitter's Email" pattern="^[a-z\d._%\-]+@[a-z]+\.[a-z]{3,}$" title="Please enter a valid email address (e.g., example@example.com)" required />
                    <input type="text" name="amount" id="amount" placeholder="Enter Amount" pattern="[0-9]*" title="Please enter numbers only" required />
                    <p class="RequestSent" id="RequestSent" style="display: none;"></p>
                    <button type="submit" id="send">Send Request</button>
                </form>
            </div>
        </div>
    </div>
    <script>

        function sent()
        {
            document.getElementById("RequestSent").style.display = "block";
            document.getElementById("send").style.display = "none";
            var sent = document.getElementById("RequestSent").innerHTML = "Request Sent Successfully";
        }

        function showAlert1()
        {
            var mail = document.getElementById("mailId").value;
            var amount = document.getElementById("amount").value;

             if(mail === "") {
                alert("Enter Mail Id");
                return false; 
            } 
            if(amount === "") {
                alert("Enter Amount");
                return false;
            }
            
            sent();
            return true;
        }

        
    </script>
</body>
</html>