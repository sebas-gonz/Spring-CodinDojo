<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${showbook.title}" />
	</h1>
	<p>
		Description:
		<c:out value="${showbook.description}" />
	</p>
	<p>
		Language:
		<c:out value="${showbook.language}" />
	</p>
	<p>
		Number of pages:
		<c:out value="${showbook.numberOfPages}" />
	</p>
	<a href="/books/${showbook.id}/edit">Edit Book</a>
	
	<form action="/books/${showbook.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>