<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Count</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1>Esta pagina aumento en +2 el contador </h1>
	<h3>Llevas <c:out value="${contador}"/> visitas</h3>
	
	<form method="get" action="/reinicio">
		<button type="submit">Reiniciar contador</button>
	</form>
	
	<h3><a href="http://localhost:8080/">Welcome User</a></h3>
</body>
</html>