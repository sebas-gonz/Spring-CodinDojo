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
			<h1>${product.name}</h1>
		</section>
		<div>
			<form accept-charset="UTF-8" action="/products/${product.id}/add" method="post">
				<label for="category">Categories: </label> 
				<select name="category" id="category">
					<c:forEach items="${categories}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				<input type="submit" class="submit" value="Add" />
			</form>
		</div>
		<fieldset>
			<table>
				<c:forEach items="${product.categories}" var="categories">
					<tr>
						<th>Category</th>
					</tr>
					<tr>
						<td>${categories.name}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</main>
</body>
</html>