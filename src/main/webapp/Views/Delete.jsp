<%@page import="maintenance.ProductIO"%>
<%@page import="maintenance.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form method="get" action="../delete?code= ${param.code}">
        Code: ${param.code}<br/>
        Description: ${param.desc}<br/>
        Price: $${param.price}<br/>
        <input name="code" value="${param.code}" hidden >
        <input type="submit" value="Delete">
    </form>
<a href="../products">Cancel</a>
</body>
</html>