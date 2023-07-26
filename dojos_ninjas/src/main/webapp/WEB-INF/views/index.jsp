<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<header>
		<a href="http://localhost:8080/dojos/new">Register</a>
		<a href="http://localhost:8080/ninjas/new">Ninja Register</a>
	</header>
	<form accept-charset="UTF-8" action="/" method="post">
		<label for="dojos">Dojos: </label> 
		<select name="dojos" id="dojos">
			<c:forEach items="${dojos}" var="dojos">
				<option value="${dojos.id}">${dojos.name} </option>
			</c:forEach>
		</select> 
		<input type="submit" class="submit" value="Search Dojo" />
	</form>
</body>
</html>