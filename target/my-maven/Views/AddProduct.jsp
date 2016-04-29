<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/myTag.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Product</title>
</head>
<body>
${message}
<form method="get" action="../addProduct">
    <label>Code</label>:      <input name="code" value="${product.code}">
        <my:markIfEmpty target="${product.code}">*</my:markIfEmpty><br/>
    <label>Description</label>:<input name="description" value="${product.description}">
        <my:markIfEmpty target="${product.description}">*</my:markIfEmpty><br/>
    <label>Price</label>:$<input name="price" value="${product.price}">
        <my:markIfEmpty target="${product.price}">*</my:markIfEmpty><br/>
    <input type="submit" value="Add Product">
</form>
<a href="../products">Cancel</a>

</body>
</html>