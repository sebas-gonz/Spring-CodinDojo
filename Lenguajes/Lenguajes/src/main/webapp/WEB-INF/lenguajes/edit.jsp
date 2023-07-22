<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/edit.css">
<title>Edit ${lenguaje.name}</title>
</head>
<body>
	<nav class="nav">
		<form action="/lenguajes/${lenguaje.id}" method="post">
			<input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
		<a href="http://localhost:8080/lenguajes">DashBoard</a>
	</nav>
	<main class="editar">
		<form:form accept-charset="UTF-8"
			action="/lenguajes/${lenguaje.id}/edit" method="post"
			modelAttribute="lenguaje">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Name: </form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator: </form:label>
				<form:errors path="creator" />
				<form:input path="creator" />
			</p>
			<p></p>
			<p>
				<form:label path="currentVersion">Version: </form:label>
				<form:errors path="currentVersion" />
				<form:input path="currentVersion" />
			</p>
			<div class="button">
			<input type="submit" value="Submit" />
			</div>
		</form:form>
	</main>
</body>
</html>