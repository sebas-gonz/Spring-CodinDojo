<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Class</title>
<link rel="stylesheet" type="text/css" href="/css/student_classes.css">
</head>
<body>
	<header>
		<nav>
			<a href="http://localhost:8080/">Home</a>
		</nav>
	</header>
	<main>
		<section>
			<h1>${student.firstName}</h1>
		</section>
		<div>
			<form accept-charset="UTF-8" action="/student/${student.id}/add" method="post">
				<label for="class">Classes: </label> 
				<select name="class" id="class">
					<c:forEach items="${clase}" var="clas">
						<option value="${clas.id}">${clas.name}</option>
					</c:forEach>
				</select>
				<input type="submit" class="submit" value="Add" />
			</form>
		</div>
		<fieldset>
			<table>
					<tr>
						<th>Class</th>
						<th>Action:</th>
					</tr>
					<c:forEach items="${student.clas}" var="clases">
					<tr>
						<td>${clases.name}</td>
						<td>
							<form action="/student/${student.id}/${clases.id}/class" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input class="search btn delete" type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</main>
</body>
</html>