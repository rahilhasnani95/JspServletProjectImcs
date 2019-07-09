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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
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
<c:if test="${not empty deletemessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${deletemessage}");
    })
    </script>
</c:if>

<c:if test="${not empty itemsoldoutmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${itemsoldoutmessage}");
    })
    </script>
</c:if>

<c:if test="${not empty finalbillmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${finalbillmessage}");
    })
    </script>
</c:if>

<c:if test="${not empty cantcheckoutmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${cantcheckoutmessage}");
    })
    </script>
</c:if>
<br>

<div style="margin-left: 20px;">
	
	<form action="ViewCartServlet" method="post">
			<input class="btn btn-info btn-lg" type="submit" value="Refresh Cart">
		</form>

	<h2>My Cart </h2>
		<table id="tb" border="1" cellpadding="10">
			<tr>
				<th>Item Id</th>
				<th>Item Name</th>
				<th>Quantity in Cart</th>
				<th>Total Price of this Item</th>
				<th>Delete Item</th>
			</tr>
			
			<c:set var="finaltotal" value="${0}"/>
			<c:forEach items="${cartlist}" var="i">
				<tr>
					<td><c:out value="${i.itemid}" /></td>
					<td><c:out value="${i.itemname}" /></td>
					<td><c:out value="${i.itemquantity}" /></td>
					<td><c:out value="${i.totalprice}" /></td>	
					<c:set var="finaltotal" value="${finaltotal + i.totalprice}" />
					
					 <td>
			 		<form action="DeleteServlet" method="post">
						<input type="hidden" name="itemid" value="${i.itemid}">
						<input type="hidden" name="itemname" value="${i.itemname}">	
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Remove Item" style="width: 100%;" >					
					</form>
					</td>	
						
				</tr>
				
			</c:forEach>
			
		</table>
		<br>
	<h4> Final Total : $ ${finaltotal} </h4><br>

 	<div style="display: inline-flex;" >
		<form action="ProductServlet" method="post">
			<input type="submit" class="btn btn-info btn-lg" value="Continue Shopping">
		</form>

		<form action="CheckoutServlet" method="post" style="margin-left: 20px;">
			<input type="hidden" name="finaltotalbill" value="${finaltotal}">
			<input class="btn btn-dark btn-lg" type="submit" value="CheckOut">
		</form>
	</div>
</div>
</body>
</html>