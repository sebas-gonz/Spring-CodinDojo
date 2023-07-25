<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<a href="http://localhost:8080/persons/new">Register</a>
	<a href="http://localhost:8080/licenses/new">New License</a>

	<form accept-charset="UTF-8" action="/" method="post">
		<label for="person">Person: </label>
		<select name="person" id="person">
			<c:forEach items="${allperson}" var="allperson">
				<option value="${allperson.id}">${allperson.firstName} ${allperson.lastName}</option>
			</c:forEach>
		</select>
		<input type="submit" class="submit" value="Search License" />
	</form>

</body>
</html>