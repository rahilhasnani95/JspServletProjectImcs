<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="text-align: center;">

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}
	%>

<h1>Welcome, ${username} </h1>
	
	<form action="Logout" method="post">
		<input type="submit" class="btn btn-danger btn-lg" value="Logout">
	</form>
	<br>
	<form action="ProductServlet" method="post">
		<input type="submit" class="btn btn-primary btn-lg" value="See Products">
	</form>
	

</body>
</html>