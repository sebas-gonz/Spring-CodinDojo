<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Student in the Class</title>
<link rel="stylesheet" type="text/css" href="/css/class_students.css">
</head>
<body>
	<header>
		<h1>${clases.name}</h1>
		<a class="dash" href="http://localhost:8080/student/new">Register Student</a>
		<a class="dash" href="http://localhost:8080/contact/new">Add Contact</a>
		<a class="dash" href="http://localhost:8080/">Home</a>
	</header>
	<main>
		<table>
				<tr>
					<th>Name</th>
				</tr>
				<c:forEach items="${clases.students}" var="student">
				<tr>
					<td>${student.firstName} ${student.lastName}</td>				
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>