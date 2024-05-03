<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="SendMoney.css">
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
            <div class="usingMail" id="usingMail" onclick="showEmail()">
               <p>Using Email Id</p> 
            </div>
            <div class="creditCard" id="creditCard" onclick="showCard()">
                <p>Using Debit Card</p>
            </div>
            <div class="bank" id="bank" onclick="showBank()">
                <p>Using Bank Account</p>
            </div>
        </div>
        <form action="usingMailId" method="post" onsubmit="return showAlert1()">
            <div class="paymentInput" id="paymentInput" style="display: none;">
                <input type="text" placeholder="Sender's Email Id" name="mailId" id="mailId" pattern="^[a-z\d._%\-]+@[a-z]+\.[a-z]{3,}$" title="Please enter a valid email address (e.g., example@example.com)" required />
                <input type="text" placeholder="Amount" name="amount" id="amount1" pattern="[0-9]*" title="Please enter numbers only" required />
                <button type="submit">Send</button>
            </div>
        </form>

        <div class="checked"></div>

        <form action="usingCard" method="post" onsubmit="return showAlert2()">
            <div class="cardPayment" id="cardInput" style="display: none;">
                <input type="text" placeholder="Your Card Number" name="card" id="card" pattern="[0-9]*" title="Please enter numbers only" required />
                <input type="text" placeholder="Your Card Expiry Date" name="expiry" id="expiry" required />
                <input type="password" placeholder="Your Card CVV" name="cvv" id="cvv" pattern="[0-9]*" title="Please enter numbers only" required />
                <input type="number" placeholder="Amount" name="amount" id="amount2" pattern="[0-9]*" title="Please enter numbers only" required />
                <button type="submit">Next</button>
            </div>
        </form>

        <form action="usingBank" method="post" onsubmit="return showAlert3()">
            <div class="accountPayment" id="accountPayment" style="display: none;">
                <input type="text" placeholder="Receiver's Name" name="name" id="name" required/>
                <input type="text" placeholder="Receiver's Account Number" name="accountNo" id="accountNo" pattern="[0-9]*" title="Please enter numbers only" required />
                <input type="text" placeholder="Receiver's IFSC" name="ifsc" id="ifsc" required/>
                <input type="number" placeholder="Amount" name="amount" id="amount3" pattern="[0-9]*" title="Please enter numbers only" required/>
                <button type="submit">Send</button>
            </div>
        </form>
        
    </div>
    <script>

        let mail = document.getElementById("usingMail");
        let card = document.getElementById("creditCard");
        let bank = document.getElementById("bank");

        mail.addEventListener("click", function(e) {
            e.currentTarget.classList.toggle("checked");
        });

        card.addEventListener("click", function(e) {
            e.currentTarget.classList.toggle("checked");
        });

        bank.addEventListener("click", function(e) {
            e.currentTarget.classList.toggle("checked");
        });

        
        function showEmail()
        {
            var email = document.getElementById("paymentInput");
            email.style.display = (email.style.display === "none") ? "block" : "none";
            var card = document.getElementById("creditCard");
            card.style.display = (card.style.display === "none") ? "block" : "none";
            var bank = document.getElementById("bank")
            bank.style.display = (bank.style.display === "none") ? "block" : "none";
        }

        function showCard()
        {
            var email = document.getElementById("usingMail");
            email.style.display = (email.style.display === "none") ? "block" : "none";
            var card = document.getElementById("cardInput");
            card.style.display = (card.style.display === "none") ? "block" : "none";
            var bank = document.getElementById("bank")
            bank.style.display = (bank.style.display === "none") ? "block" : "none";
        }
        
        function showBank()
        {
            var email = document.getElementById("usingMail");
            email.style.display = (email.style.display === "none") ? "block" : "none";
            var card = document.getElementById("creditCard");
            card.style.display = (card.style.display === "none") ? "block" : "none";
            var bank = document.getElementById("accountPayment")
            bank.style.display = (bank.style.display === "none") ? "block" : "none";
        }

        function showAlert1()
        {
            var mail = document.getElementById("mailId").value;
            var amount = document.getElementById("amount1").value;

             if(mail === "") {
                alert("Enter Mail Id");
                return false; 
            } 
            if(amount === "") {
                alert("Enter Amount");
                return false;
            }

            return true;
        }

        function showAlert2()
        {
            var card = document.getElementById("card").value;
            var expiry = document.getElementById("expiry").value;
            var cvv = document.getElementById("cvv").value;
            var amount = document.getElementById("amount2").value;

             if(card === "") {
                alert("Enter Card Details");
                return false; 
            } 
            if(expiry === "") {
                alert("Enter Expiry Date");
                return false; 
            }
            if(cvv === "") {
                alert("Enter CVV");
                return false;
            }
            if(amount === "") {
                alert("Enter Amount");
                return false;
            }

            return true;
        }

        function showAlert3()
        {
            var name = document.getElementById("name").value;
            var accountNo = document.getElementById("accountNo").value;
            var ifsc = document.getElementById("ifsc").value;
            var amount = document.getElementById("amount3").value;

             if(name === "") {
                alert("Enter Account Holder Name");
                return false; 
            } 
            if(accountNo === "") {
                alert("Enter Account No");
                return false; 
            }
            if(ifsc === "") {
                alert("Enter IFSC");
                return false;
            }
            if(amount === "") {
                alert("Enter Amount");
                return false;
            }

            return true;
        }
    </script>
</body>
</html>