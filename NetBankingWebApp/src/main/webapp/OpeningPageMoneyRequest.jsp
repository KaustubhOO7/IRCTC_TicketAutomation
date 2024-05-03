<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" href="OpeningPageMoneyRequest.css">
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
       <h2>DashBoard</h2>
       <div class="cards">
           <div class="card1">
               <h4>Balance</h4>
               ${balance}
           </div>
           <div class="card2">
               <h4>Income</h4>
               30000
           </div>
           <div class="card3">
               <h4>Expense</h4>
               15000
           </div>
           <div class="card4">
               <h4>Savings</h4>
               15000
           </div>
       </div>
       <div class="action">
           <h3>Action</h3>
           <a href="SendMoney" class="send">
              <h4>Send</h4>
           </a>
           <a href="RequestMoney.jsp" class="receive">
               <h4>Request</h4>
           </a>
           
       </div>
       <div class="history">
           <h1>Payment History</h1>
           <table>
               <thead>
                   <tr>
                       <th>Amount</th>
                       <th>Date</th>
                       <th>Status</th>
                   </tr>
                   <tbody>
                       <tr>
                         <td>${data1.amount}</td>
                         <td>${data1.date}</td>
                         <td>${data1.status}</td>
                       </tr>
                       <tr>
                           <td>${data2.amount}</td>
                           <td>${data2.date}</td>
                           <td>${data2.status}</td>
                       </tr>
                       <tr>
                           <td>${data3.amount}</td>
                           <td>${data3.date}</td>
                           <td>${data3.status}</td>
                       </tr>
                       <tr>
                           <td>${data4.amount}</td>
                           <td>${data4.date}</td>
                           <td>${data4.status}</td>
                       </tr>
                       <tr>
                           <td>${data5.amount}</td>
                           <td>${data5.date}</td>
                           <td>${data5.status}</td>
                       </tr>
                     </tbody>
               </thead>
           </table>
       </div>
       <form action="payMoney" id="payMoney">
           <div class="moneyRequest"></div>
           <div class="moneyContainer">
            <p>Requested By</p>
            <p>${requester}</p>
            <p>${amount}</p>
            <button type="submit" id="payButton">Pay</button>
           </div>
       </form>

       <form action="declineMoney" id="cancelMoney" method="post">
            <button type="submit" id="cancelButton">Decline</button>
       </form>
   </div>
</body>
</html>