<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Product</title>
</head>
<body>
<form method="get" action="../edit">
Code: ${param.code}<br/>
Description:<input name="description" value="${param.desc}"><br/>
Price:$<input name="price" value="${param.price}"><br/>
<input type="hidden" name="code" value="${param.code}">
<input type="submit" value="Edit">
</form>
<a href="../products">Cancel</a>

</body>
</html>