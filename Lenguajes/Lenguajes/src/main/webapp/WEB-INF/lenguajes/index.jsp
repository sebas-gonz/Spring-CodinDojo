<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
<meta charset="ISO-8859-1">
<title>Lenguajes</title>
</head>
<body>
	<div class="tabla">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lenguajes}" var="lenguaje">
					<tr>
						<td><a href="http://localhost:8080/lenguajes/${lenguaje.id}"><c:out
									value="${lenguaje.name}" /> </a></td>
						<td><c:out value="${lenguaje.creator}" /></td>
						<td><c:out value="${lenguaje.currentVersion}" /></td>
						<td>
							<form action="/lenguajes/${lenguaje.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete"> <a href="http://localhost:8080/lenguajes/${lenguaje.id}/edit">Edit</a>
							</form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="createLeng">
		<form:form accept-charset="UTF-8" action="/lenguajes" method="post"
			modelAttribute="lenguaje">
			<p>
				<form:label path="name">Name: </form:label>
				<form:errors path="name" />
				<form:input class="datos" path="name" />
			</p>
			<p>
				<form:label path="creator">Creator: </form:label>
				<form:errors path="creator" />
				<form:input class="datos" path="creator" />
			</p>
			<p>
				<form:label path="currentVersion">Version: </form:label>
				<form:errors path="currentVersion" />
				<form:input class="datos" path="currentVersion" />
			</p>
			<div class="crear">
				<input type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>