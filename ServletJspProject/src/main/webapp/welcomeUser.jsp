<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}
	%>

	Welcome, ${username}
	<br>
	<br>

	<form action="Logout" method="post">
		<input type="submit" class="btn" value="Logout">
	</form>
	<br>
	<form action="ProductServlet" method="post">
		<input type="submit" class="btn" value="See Products">
	</form>
	

</body>
</html>