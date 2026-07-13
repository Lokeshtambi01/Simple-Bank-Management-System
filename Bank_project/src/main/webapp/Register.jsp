<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}
body{
	
    background: linear-gradient(135deg, #0f4c81, #1e88e5);
	color: #fffbf4;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	overflow: none;
	font-family: playfair-display-black;
}
div{
height: 580px;
width: 600px;
background: white;
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
    box-shadow: 0 0 20px rgba(0,0,0,0.2);
}
h1{
color: #0f4c81;
}
h2{
color: #555;
}
label{
line-height: 12px;
font-size: 20px;
color: #0f4c81;
}
input{
width: 300px;
padding: 12px;
font-size: 16px;
border: 2px solid #ccc;
border-radius: 8px;
outline: none;
transition: 0.3s;
}

input:focus{
border-color: blue;
box-shadow: 0 0 5px rgba(0,0,255,0.5);
}
#sub{
background-color: #0f4c81;
color: white;
}
#sub:hover{
    background-color: #1e88e5;
    transform: translateY(-3px);

}
</style>
</head>
<body>
<div>

	<h1>Welcome to XYZ Bank</h1>
	<h2>Register your account to use our Services</h2><br>
	
	<form action="regs" method="post">
		<label>Name</label><br>
		<input type="text" placeholder="Enter your Name" name="holder_name"><br><br>
		<label>Phone Number</label><br>
		<input type="text" placeholder="Enter your Phone Number" name="holder_phonenumber"><br><br>
		<label>Address</label><br>
		<input type="text" placeholder="Enter your Address" name="holder_address"><br><br>
		<label>PIN</label><br>
		<input type="text" placeholder="PIN" name="Pin"><br><br>
		<input type="submit" id="sub" value="Submit">
	</form>
</div>
</body>
</html>