<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer Money</title>

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
            padding:30px;
            border-radius:15px;
            box-shadow:0 5px 20px rgba(0,0,0,0.2);
        }

        h2{
            text-align:center;
            color:#0f4c81;
            margin-bottom:25px;
        }

        .input-group{
            margin-bottom:15px;
        }

        label{
            display:block;
            margin-bottom:5px;
            font-weight:bold;
        }

        input{
            width:100%;
            padding:12px;
            border:1px solid #ccc;
            border-radius:8px;
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
            margin-top:10px;
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

    <h2>🔄 Transfer Money</h2>

<form action="transfer" method="post">
    <input type="text" name="receiver" required>
    <input type="number" name="tamount" required>
    <button type="submit">Transfer</button>
</form>

    <a href="Services.jsp" class="back">
        ← Back to Dashboard
    </a>

</div>

</body>
</html>