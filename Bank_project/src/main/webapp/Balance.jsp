<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check Balance</title>

    <style>
        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
            font-family:Arial, sans-serif;
        }

        body{
            height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
            background:linear-gradient(135deg,#0f4c81,#1e88e5);
        }

        .container{
            width:450px;
            background:white;
            padding:35px;
            border-radius:15px;
            text-align:center;
            box-shadow:0 5px 20px rgba(0,0,0,0.2);
        }

        h2{
            color:#0f4c81;
            margin-bottom:20px;
        }

        .balance-box{
            margin:25px 0;
            padding:25px;
            background:#f4f6f9;
            border-radius:10px;
        }

        .balance-label{
            font-size:18px;
            color:#555;
        }

        .balance{
            font-size:36px;
            font-weight:bold;
            color:green;
            margin-top:10px;
        }

        .btn{
            display:inline-block;
            text-decoration:none;
            background:#0f4c81;
            color:white;
            padding:12px 20px;
            border-radius:8px;
            margin-top:15px;
            transition:0.3s;
        }

        .btn:hover{
            background:#1e88e5;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>🏦 Account Balance</h2>

    <div class="balance-box">
        <div class="balance-label">Available Balance</div>
        <div class="balance">
             ₹ <%= session.getAttribute("amount") %>
        </div>
    </div>

    <a href="Services.jsp" class="btn">Back to Dashboard</a>

</div>

</body>
</html>