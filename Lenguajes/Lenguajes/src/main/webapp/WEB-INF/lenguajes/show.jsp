<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/show.css">
<meta charset="ISO-8859-1">
<title>Show ${showlenguaje.name}</title>
</head>
<body>
		<a class="dash" href="http://localhost:8080/lenguajes">DashBoard</a>
	<p>
		<c:out value="${showlenguaje.name}" />
	</p>
	<p>
		<c:out value="${showlenguaje.creator}" />
	</p>
	<p>
		<c:out value="${showlenguaje.currentVersion}" />
	</p>
	<a class="edit" class="edit" href="/lenguajes/${showlenguaje.id}/edit">Edit</a>

	<form action="/lenguajes/${showlenguaje.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>