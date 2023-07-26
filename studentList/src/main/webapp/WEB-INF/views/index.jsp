<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<header>
		<a href="dorms/new">Register Dormitory</a>
		<a href="student/new">New Student</a>
		<a href="contact/new">Add Contact</a>
		<a href="/student">All Students</a>
	</header>
	<form accept-charset="UTF-8" action="/" method="post">
		<label for="dormitory">Dormitories: </label> 
		<select name="dormitory" id="dormitory">
			<c:forEach items="${dormitories}" var="dormitory">
				<option value="${dormitory.id}">${dormitory.name} </option>
			</c:forEach>
		</select> 
		<input type="submit" class="submit" value="Search Dormitory" />
	</form>
</body>
</html>