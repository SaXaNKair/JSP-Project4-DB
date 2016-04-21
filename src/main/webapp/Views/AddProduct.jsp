<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Product</title>
</head>
<body>
<form method="get" action="../addProduct">
Code: <input name="code" ><br/>
Description:<input name="description" ><br/>
Price:$<input name="price"><br/>
<input type="submit" value="Add Product">
</form>
<a href="../products">Cancel</a>

</body>
</html>