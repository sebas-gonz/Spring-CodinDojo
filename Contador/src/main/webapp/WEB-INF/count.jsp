<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1>Haz visitado <a href="http://localhost:8080/">Welcome user </a><c:out value="${contador}"/> veces </h1>
	<h2><a href="http://localhost:8080/">Otra visita?</a></h2>
	<h2><a href="http://localhost:8080/reset">reiniciar contador</a></h2>
</body>
</html>