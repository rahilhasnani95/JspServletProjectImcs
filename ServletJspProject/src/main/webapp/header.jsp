<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.btn {
position: relative;
top: 10px;
width: 15%;
background-color: "green";
color: "red"

}
</style>
</head>
<body>

<a href="welcomeUser.jsp"><input type="button" class="btn" value="Back to Home"></a> 
<br><br>
	<form action="Logout" method="post">
		<input type="submit" class="btn" value="Logout">
	</form>


</body>
</html>