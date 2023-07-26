<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
<link rel="stylesheet" type="text/css" href="/css/all_students.css">
</head>
<body>
	<header>
		<h1>All Students</h1>
		<a class="dash" href="http://localhost:8080/student/new">Register Student</a>
		<a class="dash" href="http://localhost:8080/contact/new">Add Contact</a>
		<a class="dash" href="http://localhost:8080/">Home</a>
	</header>
	<main>
		<table>
			<c:forEach items="${student}" var="student">
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
				<tr>
					<td>${student.firstName} ${student.lastName}</td>
					<td>${student.age}</td>
					<td>${student.contact.address}</td>
					<td>${student.contact.city}</td>
					<td>${student.contact.state}</td>
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>