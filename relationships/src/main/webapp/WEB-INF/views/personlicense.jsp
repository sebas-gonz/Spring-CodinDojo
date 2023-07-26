<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>License Info</title>
<link rel="stylesheet" type="text/css" href="/css/personlicense.css">
</head>
<body>
	<header>
		<nav>
			<a href="http://localhost:8080/">index</a>
		</nav>
	</header>
	<main>
		<section>
			<h1>${person.firstName} ${person.lastName}</h1>
		</section>
		<fieldset>
			<table>
				<tr>
					<th>License Number: </th>
					<td>${person.license.number}</td>
				</tr>
				<tr>
					<th>State: </th>
					<td>${person.license.state}</td>
				</tr>
				<tr>
					<th>Expiration Date: </th>
					<td> <fmt:formatDate value="${person.license.expirationDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</table>
		</fieldset>
	</main>
</body>
</html>