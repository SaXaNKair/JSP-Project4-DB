
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../styles.css" rel="stylesheet" type="text/css"	>
<title>All Products</title>
</head>
<body>

<table>
<thead>
	<tr>
		<td>Code</td>
		<td>Description</td>
		<td>Price</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${products}" var="p">
	<tr>
		<td>${p.code}</td>
		<td>${p.description}</td>
		<td>$ ${p.price}</td>
		<td><a href="Views/Delete.jsp?code=${p.code}&desc=${p.description}&price=${p.price}">Delete</a></td>
		<td><a href="Views/Edit.jsp?code=${p.code}&desc=${p.description}&price=${p.price}">Edit</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
<form action="Views/AddProduct.jsp">
	<input type="submit" value="Add">
</form>

</body>
</html>












