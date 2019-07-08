<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>

	<form action="UserServlet" method="post" >
		
		Enter Username : <input type="text" name="username" required="required"> 
		Enter Password : <input type="password" name="password" required="required"><br><br>
		<input type="submit" value="Login">
		
	</form>

</body>
</html>