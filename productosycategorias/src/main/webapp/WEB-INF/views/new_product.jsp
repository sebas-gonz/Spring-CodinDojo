<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Products</title>
<link rel="stylesheet" type="text/css" href="/css/product.css">
</head>
<body>
	<header>
		<nav>
			<a href="http://localhost:8080/">Home</a>
		</nav>
	</header>
	<main>
		<form:form accept-charset="UTF-8" action="/products/new" method="post"
			modelAttribute="product">
			<fieldset>
				<legend>New Product</legend>
				<div>
					<form:label path="name" for="name">Name: </form:label>
					<form:input type="text" path="name" />
					<form:errors path="name" cssClass="error" />
				</div>
				<div>
					<form:label path="description" for="description">Description: </form:label>
					<form:input type="area" path="description" />
					<form:errors path="description" cssClass="error" />
				</div>
				<div>
					<form:label path="price" for="price">Price:</form:label>
					<form:input type="number" path="price" />
					<form:errors path="price" cssClass="error" />
				</div>
			</fieldset>
			<p>
				<input type="submit" class="submit" value="Create" />
			</p>
		</form:form>
	</main>
</body>
</html>