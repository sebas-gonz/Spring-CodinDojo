<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hora Actual</title>
<script src="js/hour.js"></script>
<link rel="stylesheet" href="css/hour.css">
</head>
<body>
	<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1><a:out value="${hora}" /></h1>
</body>
</html>