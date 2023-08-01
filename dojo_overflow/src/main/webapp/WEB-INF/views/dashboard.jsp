<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBoard</title>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
</head>
<body>
	<header>
		<h1>Question Dashboard</h1>
	</header>
	<main>
		<table>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
			<c:forEach items="${question}" var="q">
				<tr>
					<td><a href="/question/${q.id}">${q.question}</a></td>
					<td>
					<c:forEach items="${q.tag}" var="tag">
						${tag.subject}
					</c:forEach>
					</td>

				</tr>
			</c:forEach>
		</table>
	</main>
	<footer>
		<a href="/question/new">New Question</a>
	</footer>
</body>
</html>