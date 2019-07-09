<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/header.css">
</head>
<body>

	<div>
		<form action="Logout" method="post">
			<ul>
				<li class="welcome"><a href="welcomeUser.jsp"><input type="button" class="btn btn-info btn-lg" value="Back to Home"></a></li>
				<li class="welcome">Welcome, ${username}</li>
				<li><input type="submit" class="btn btn-danger btn-lg" value="Logout"> </li>
				
			</ul>
		</form>
	</div>

	<!-- 
 <i class="fa fa-shopping-cart w3-margin-right"></i>
      <i class="fa fa-search"></i> -->

</body>
</html>