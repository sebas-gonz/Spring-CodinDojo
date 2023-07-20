<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/books/${editBook.id}/edit" method="post">
	<input type="hidden" name="id" value="${editBook.id}">
	    <label for="title">Editar titulo: </label>
	<input type="text" id="title" name="title"><br><br>
	
	<label for="desc">Editar descripcion: </label>
	<input type="text" id="desc" name="description"><br><br>
	
	<label for="lang">Editar lenguaje: </label>
	<input type="text" id="lang" name="languaje"><br><br>
	
	<label for="pages">Editar numero de paginas: </label>
	<input type="text" id="pages" name="pages"><br><br>
	
	<input type="submit" value="Actualizar">
	</form> 
</body>
</html>