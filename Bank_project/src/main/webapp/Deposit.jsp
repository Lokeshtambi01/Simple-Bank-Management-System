<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit Money</title>

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
            width:400px;
            background:white;
            padding:30px;
            border-radius:15px;
            box-shadow:0 5px 20px rgba(0,0,0,0.2);
        }

        h2{
            text-align:center;
            color:#0f4c81;
            margin-bottom:25px;
        }

        label{
            display:block;
            margin-bottom:8px;
            font-weight:bold;
        }

        input{
            width:100%;
            padding:12px;
            border:1px solid #ccc;
            border-radius:8px;
            margin-bottom:20px;
            font-size:16px;
        }

        input:focus{
            outline:none;
            border-color:#1e88e5;
        }

        button{
            width:100%;
            padding:12px;
            border:none;
            border-radius:8px;
            background:#0f4c81;
            color:white;
            font-size:16px;
            cursor:pointer;
            transition:0.3s;
        }

        button:hover{
            background:#1e88e5;
        }

        .back{
            display:block;
            text-align:center;
            margin-top:15px;
            text-decoration:none;
            color:#0f4c81;
            font-weight:bold;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>💰 Deposit Money</h2>

    <form action="DepositServlet" method="post">

        <label>Enter Amount</label>
        <input
            type="number"
            name="damount"
            min="1"
            placeholder="Enter deposit amount"
            required>

        <button type="submit">Deposit</button>

    </form>

    <a href="Services.jsp" class="back">← Back to Dashboard</a>
</div>

</body>
</html>