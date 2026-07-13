<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Dashboard</title>
    <link rel="stylesheet" href="services.css">
</head>
<body>

    <header>
        <h1>Bank Management System</h1>
        <p>Welcome, <%= session.getAttribute("user") %> </p>
    </header>

    <div class="services-container">

        <div class="card">
            <h2>💰 Deposit</h2>
            <p>Add money to your account securely.</p>
            <a href="Deposit.jsp">Open</a>
        </div>

        <div class="card">
            <h2>💸 Withdraw</h2>
            <p>Withdraw money from your account.</p>
            <a href="Withdraw.jsp">Open</a>
        </div>

        <div class="card">
            <h2>🏦 Check Balance</h2>
            <p>View your current account balance.</p>
            <a href="Balance">Open</a>
        </div>


        <div class="card">
            <h2>🔄 Transfer Money</h2>
            <p>Transfer money to another account.</p>
            <a href="transfermoney.jsp">Open</a>
        </div>

        <div class="card">
            <h2>🚪 Logout</h2>
            <p>Sign out from your account safely.</p>
            <a href="main.html">Logout</a>
        </div>

    </div>

</body>
</html>