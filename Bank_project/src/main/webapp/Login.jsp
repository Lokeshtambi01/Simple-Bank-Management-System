<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Login</title>
    <style type="text/css">
    	*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body{
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(135deg, #0f4c81, #1e88e5);
}

.login-container{
    width: 350px;
    background: white;
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 0 20px rgba(0,0,0,0.2);
}

.login-container h2{
    text-align: center;
    margin-bottom: 25px;
    color: #0f4c81;
}

.input-group{
    margin-bottom: 15px;
}

.input-group label{
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

.input-group input{
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 8px;
    outline: none;
}

.input-group input:focus{
    border-color: #1e88e5;
}

button{
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 8px;
    background: #0f4c81;
    color: white;
    font-size: 16px;
    cursor: pointer;
    transition: 0.3s;
}

button:hover{
    background: #1e88e5;
}

p{
    text-align: center;
    margin-top: 15px;
}

p a{
    text-decoration: none;
    color: #0f4c81;
    font-weight: bold;
}
    </style>
</head>
<body>

    <div class="login-container">
        <h2>Bank Login</h2>

        <form action="logs" method="post">
            <div class="input-group">
                <label>Account Holder Name</label>
                <input type="text" name="name" placeholder="Enter your name" required>
            </div>

            <div class="input-group">
                <label>PIN</label>
                <input type="password" name="pin" placeholder="Enter your PIN" required>
            </div>

            <button type="submit">Login</button>
        </form>

        <p>Don't have an account? <a href="Register.jsp">Register</a></p>
    </div>

</body>
</html>