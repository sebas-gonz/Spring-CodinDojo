<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="/css/middle.css">
</head>
<body>
<header>
		<nav>
			<a href="http://localhost:8080/">Home</a>
		</nav>
	</header>
	<main>
		<section>
			<h1>${categories.name}</h1>
		</section>
		<div>
			<form accept-charset="UTF-8" action="/categories/${categories.id}/add" method="post">
				<label for="product">Products: </label> 
				<select name="product" id="category">
					<c:forEach items="${products}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
				<input type="submit" class="submit" value="Add" />
			</form>
		</div>
		<fieldset>
			<table>
				<c:forEach items="${categories.products}" var="product">
					<tr>
						<th>Product</th>
					</tr>
					<tr>
						<td>${product.name}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</main>
</body>
</html>