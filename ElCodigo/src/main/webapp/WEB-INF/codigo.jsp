<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <h2 class="error"><c:out value="${error}"/></h2>
	<h2>¿Cual es el codigo?</h2>
	<form method="POST" action="/codigo">
	<label><input type="password" name="password"></label>
	<button>Intentar Codigo</button>
	</form>
</body>
</html>