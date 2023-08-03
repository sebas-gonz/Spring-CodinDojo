<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<th>Name</th>
			<th>Cities</th>
			<th>Percentage</th>
		</thead>
		<tbody>
			<c:forEach var="row" items="${tabla}">
				<tr>
					<td>${row[0]}</td>
					<td>${row[1]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>