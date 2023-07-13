<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fecha Actual</title>
<script src="js/date.js"></script>
<link rel="stylesheet" href="css/date.css">
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1><c:out value="${fecha}" /></h1>
</body>
</html>