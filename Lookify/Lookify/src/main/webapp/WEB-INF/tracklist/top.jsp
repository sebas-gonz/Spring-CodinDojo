<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten Songs</title>
<link rel="stylesheet" type="text/css" href="/css/top.css">
</head>
<body>
	<nav>
		<h1>Top ten songs</h1>
		<a class="dash" href="http://localhost:8080/dashboard">DashBoard</a>
	</nav>
	<main>
		<table>
		<c:forEach items="${topten}" var="topten">
			<tr>
				<td><c:out value="${topten.rating}" /> - </td>
				<td><a href="http://localhost:8080/songs/${topten.id}"><c:out value="${topten.title}" /></a></td>
				<td><c:out value="${topten.artist}" /></td>
			</tr>
		</c:forEach>
		</table>
	</main>
</body>
</html>