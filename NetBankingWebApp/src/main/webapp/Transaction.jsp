<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="Transaction.css">
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
        <h2>All Transaction</h2>
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
                        <c:forEach items="${transactions}" var="transaction">
                            <tr>
                                <td><c:out value="${transaction.amount}" /></td>
                                <td><c:out value="${transaction.date}" /></td>
                                <td><c:out value="${transaction.status}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
        
                </thead>
            </table>
        </div>
    </div>
    
</body>
</html>