<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/css/home.css">
</head>
<body>
	<header>
		<a href="http://localhost:8080/products/new">Register product</a>
		<a href="http://localhost:8080/categories/new">Add Category</a>
	</header>
	<form accept-charset="UTF-8" action="/products" method="post">
		<label for="product">Products: </label> 
		<select name="products" id="product">
			<c:forEach items="${products}" var="product">
				<option value="${product.id}">${product.name} </option>
			</c:forEach>
		</select> 
		<input type="submit" class="submit" value="Search Product" />
	</form>
	
	<form accept-charset="UTF-8" action="/categories" method="post">
		<label for="categories">Categories: </label> 
		<select name="categories" id="categories">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.name} </option>
			</c:forEach>
		</select> 
		<input type="submit" class="submit" value="Search Category" />
	</form>
</body>
</html>