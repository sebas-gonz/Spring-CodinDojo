<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${dojo_ninjas.name} Ninjas Location</title>
<link rel="stylesheet" type="text/css" href="/css/dojo_ninjas.css">
</head>
<body>
	<header>
		<nav>
			<a href="http://localhost:8080/">index</a>
		</nav>
	</header>
	<main>
		<section>
			<h1>${dojo_ninjas.name}</h1>
		</section>
		<fieldset>
			<table>
				<c:forEach items="${dojo_ninjas.ninjas}" var="ninja">
					<tr>
						<th>First Name: </th>
						<th>Last Name: </th>
						<th>Age: </th>
					</tr>
					<tr>
						<td>${ninja.firstName}</td>
						<td>${ninja.lastName}</td>
						<td>${ninja.age}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</main>
</body>
</html>