<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Informacion entregada</h1>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:out value="${error}" />
	<table>
		<tr>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><c:out value="${nombre}" /></td>
		</tr>
		<tr>
			<td>Ubicacion del dojo</td>
			<td><c:out value="${dojos}" /></td>
		</tr>
		<tr>
			<td>Lenguaje de programacion</td>
			<td><c:out value="${lenguaje}" /></td>
		</tr>
		<tr>
			<td>Descripcion</td>
			<td><c:out value="${descripcion}" /></td>
		</tr>

	</table>
</body>
</html>