<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
<title>Dashboard</title>
</head>
<body>
	<nav>
		<a href="/songs/new">Add New</a>
		<a href="/search/topten">Top Songs</a>
			<form action="/dashboard" method="post">
					<input class="search" type="search" name="artist" placeholder="Search artist">
					<input class="btn" type="submit" value="New Search" />
			</form>
		
	</nav>
	
	<main>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tracklist}" var="tracklist">
					<tr>
						<td><a href="http://localhost:8080/songs/${tracklist.id}"><c:out value="${tracklist.title}" /> </a></td>
						<td><c:out value="${tracklist.rating}" /></td>
						<td>
							<form action="/dashboard/${tracklist.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input	class="search btn delete" type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>