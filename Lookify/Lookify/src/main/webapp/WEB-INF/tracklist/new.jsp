<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Song</title>
<link rel="stylesheet" type="text/css" href="/css/new.css">
</head>
<body>
	<header>
		<a href="http://localhost:8080/dashboard">Dashboard</a>
	</header>
	<main>
		<form:form accept-charset="UTF-8" action="/songs" method="post"
			modelAttribute="song">
			<table>
				<tr>
					<td><form:label path="title">Title: </form:label> 
						<form:errors path="title" /></td>
					<td><form:input class="input" path="title" /></td>
				</tr>
				<tr>
					<td><form:label path="artist">Artist: </form:label> 
					<form:errors path="artist" /></td>
					<td><form:input class="input" path="artist" /></td>
				</tr>
				<tr>
					<td><form:label path="rating">Rating (1-10): </form:label> <form:errors path="rating" /></td>
					<td><form:input class="input" type="number" min="1"
							max="10" path="rating" /></td>
				</tr>

			</table>
			<p><input class="submit" type="submit" value="Add Song" /> </p>
		</form:form>
	</main>
</body>
</html>