<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.btn {
top: 10px;
width: 15%;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	

	if(session.getAttribute("username") == null)
	{
		response.sendRedirect("index.jsp");
	}
	%>

 <c:if test="${not empty addmessage}">
    <script>
    window.addEventListener("load",function(){
         alert("${addmessage}");
    })
    </script>
</c:if>
<c:if test="${not empty emptycartmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${emptycartmessage}");
    })
    </script>
</c:if>

<h2>List of Products</h2>
	<table id="tb" border="1" cellpadding="10">
		<tr>
			<th>Item Id</th>
			<th>Name</th>
			<th>Quantity Left</th>
			<th>Price</th>
			<th>Enter quantity to buy</th>
			
		</tr>
		
		<c:forEach items="${productlist}" var="i">
			<tr>
				<td><c:out value="${i.itemid}" /></td>
				<td><c:out value="${i.itemname}" /></td>
				<td><c:out value="${i.itemquantity}" /></td>
				<td><c:out value="${i.itemprice}" /></td>	
							
				<td>
				<form action="CartServlet" method="post">
					<input type="hidden" name="itemid" value="${i.itemid}">
					<input type="hidden" name="itemprice" value="${i.itemprice}">
					<input type="hidden" name="itemname" value="${i.itemname}">															
					<input type="number" name="qty" placeholder="Enter quantity" required="required" min="1" max="${i.itemquantity}">
					<input type="submit" class="btn btn-outline-info" value="Add to Cart" style="width: 60%;">					
				</form>
				</td>		
			</tr>
			
		</c:forEach>
	</table>
<br>
	<form action="ViewCartServlet" method="post">
		<input class="btn btn-info" type="submit" value="View Cart">
<!-- 		<i class="fa fa-shopping-cart w3-margin-right" style="size: 30%;"></i>
 -->	</form>
</body>
</html>