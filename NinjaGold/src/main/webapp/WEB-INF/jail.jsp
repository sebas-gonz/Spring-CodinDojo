<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Juego Perdido</title>
<link
	href="https://fonts.googleapis.com/css2?family=Tektur&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/jail.css">
<script src="/js/boton.js"></script>
</head>
<body>
	<main class="contenedor">
	
		<header class="titulo">
			<h1>¡Juego perdido!</h1>
		</header>
		
		<figure class="informacion">
			<p>Tienes una deuda de<span class="oro">${oro}</span>en el banco</p>
			
			<p>Ahora estas en la carcel.</p>
			
			<img src="images/inprison.jpg" alt="jail">
			
			<p>¿Quieres reiniciar el juego?</p>
		</figure>
		
		<footer class="final">
		
			<div class="button-container-1">
				<form method="POST" action="/reset">
					<button type="submit">Reiniciar</button>
				</form>
			</div>
			
		</footer>
		
	</main>
</body>
</html>