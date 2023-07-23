<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${song.title}</title>
<link rel="stylesheet" type="text/css" href="/css/song.css">
</head>
<body>
	<header>
		<a class="dash" href="http://localhost:8080/dashboard">DashBoard</a>
	</header>
	<main>
		<table>
			<tr>
				<td>Title</td>
				<td><c:out value="${song.title}" /></td>
			</tr>
			<tr>
			<td>Artist</td>
				<td><c:out value="${song.artist}" /></td>
			</tr>
			<tr>
				<td>Rating</td>
				<td><c:out value="${song.rating}" /></td>
			</tr>
		</table>
			<form action="/dashboard/${song.id}" method="post">
			<input type="hidden" name="_method" value="delete"> 
			<input class="delete" type="submit" value="Delete">
			</form>		

	</main>

</body>
</html>