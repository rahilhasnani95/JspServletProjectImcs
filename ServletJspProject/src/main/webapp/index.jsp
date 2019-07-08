<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- <style type="text/css">
.btn {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
form{
	padding: 10px 32px;
	text-align: center;
	align-content: center;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	
}
</style> -->
</head>
<body style="text-align: center;">
<h1>Login Form</h1>

	<form class="indexform" action="UserServlet" method="post" >
		
		Enter Username : <input type="text" name="username" required="required"> <br><br>
		Enter Password : <input type="password" name="password" required="required"><br><br>
		<input class="btn btn-success btn-lg" type="submit" value="Login">
	</form>

</body>
</html>