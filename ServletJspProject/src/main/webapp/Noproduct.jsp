<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
<h1>Sorry,  No Products Right Now! Shop some other time</h1>

<a href="welcomeUser.jsp">Go To Home</a>
</body>
</html>