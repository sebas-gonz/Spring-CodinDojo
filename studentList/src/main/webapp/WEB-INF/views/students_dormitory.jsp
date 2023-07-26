<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/students_dormitory.css">
</head>
<body>
	<header>
		<nav>
			<a href="http://localhost:8080/">Home</a>
		</nav>
	</header>
	<main>
		<section>
			<h1>${dormitory.name}</h1>
		</section>
		<div>
			<form accept-charset="UTF-8" action="/dorms/${dormitory.id}/add" method="post">
				<label for="student">Students: </label> 
				<select name="student" id="student">
					<c:forEach items="${students}" var="student">
						<option value="${student.id}">${student.firstName} ${student.lastName}</option>
					</c:forEach>
				</select>
				<input type="submit" class="submit" value="Add" />
			</form>
		</div>
		<fieldset>
			<table>
				<c:forEach items="${dormitory.students}" var="student">
					<tr>
						<th>Name:</th>
						<th>Action:</th>
					</tr>
					<tr>
						<td>${student.firstName} ${student.lastName}</td>
						<td>
							<form action="/student/${dormitory.id}/${student.id}" method="post">
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