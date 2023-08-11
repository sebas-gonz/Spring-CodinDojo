<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/search.css">
<title>Search: ${artist}</title>
</head>
<body>
	<nav>
		<h1>Songs by artist: ${artist} </h1>
		<form action="/dashboard" method="post">
				<input class="search" type="search" name="artist" placeholder="Search artist">
				<input class="btn" type="submit" value="New Search" />
		</form>
		<a class="dash" href="http://localhost:8080/dashboard">DashBoard</a>
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
				<c:forEach items="${songs}" var="songs">
					<tr>
						<td><a href="http://localhost:8080/songs/${songs.id}"><c:out value="${songs.title}" /> </a></td>
						<td><c:out value="${songs.rating}" /></td>
						<td>
							<form action="/dashboard/${songs.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input class="delete" type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>