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
background-color: "green";
color: "red"
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

<c:if test="${not empty deletemessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${deletemessage}");
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

<h2>My Cart</h2>
	<table id="tb" border="1" cellpadding="10">
		<tr>
			<th>Item Id</th>
			<th>Item Name</th>
			<th>Quantity in Cart</th>
			<th>Total Price of this Item</th>
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
					<input type="submit" value="Remove Item">					
				</form>
				</td>	
					
			</tr>
			
		</c:forEach>
		
	</table>
<h3> Final Total : 	${finaltotal} </h3>
<br>
<a href="product.jsp"><input type="button" class="btn" value="Add More Products"></a> 
<br><br>

	<form action="CheckoutServlet" method="post">
		<input type="hidden" name="finaltotalbill" value="${finaltotal}">
		<input class="btn" type="submit" value="CheckOut">
	</form>

</body>
</html>