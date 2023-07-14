<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/result">
	<label for="name">Tu nombre: </label>
	<input type="text" id="name" name="nombre"><br><br>
	
	<label for="ubicacion">Ubicacion del Dojo: </label>
	<select id="ubicacion" name="dojos">
		<option value="Santiago-Chile">Santiago-Chile</option>
		<option value="Bogotá-Colombia">Bogotá-Colombia</option>
		<option value="Buenos Aires-Argentina">Buenos Aires-Argentina</option>
		<option value="Sao Paulo-Brasil">Sao Paulo-Brasil</option>
	</select><br><br>
	
	<label for="lenguaje">Lenguaje de programacion: </label>
	<select id="lenguaje" name="lenguaje">
		<option value="Java">Java</option>
		<option value="Python">Python</option>
		<option value="C++">C++</option>
		<option value="C#">C#</option>
	</select><br><br>
	
	<label for="descripcion">Puedes escribir una pequeña descripcion de ti (Opcional): </label><br>
	<textarea id="descripcion" name="comentarios" rows="4" cols="50"></textarea><br>
	<input type="submit" value="Entregar">
		
	</form>
</body>
</html>