<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<link
	href="https://fonts.googleapis.com/css2?family=Tektur&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Lilita+One&family=Tektur&display=swap"
	rel="stylesheet">
	<script src="/js/script.js"></script>
	<link rel="shortcut icon" href="images/scaredy.png">
	
</head>
<body>
	<header class="puntuacion">
		<h1>Tu oro:</h1>
		<div class="oro">
			<h1>
				<span class="${oro < 0 ? 'deuda' : ''}"> <c:out
						value="${oro}" /> <img src="images/gold-ingots.png" alt="oro">
				</span>
			</h1>
		</div>
		<form method="POST" action="/reset">
			<button class="btn draw-border" type="submit">ReiniciarJuego</button>
		</form>
	</header>

	<main class="principal">
		<article class="actividades granja">
			<form method="POST" action="/granja">
				<h2>Granja</h2>
				<p>
					(Ganas entre 10 - 20 de <span class="orocolor">oro</span>)
				</p>
				<label for="granja"></label>
				<button type="submit">¡Ir a la Granja!</button>
			</form>
		</article>

		<article class="actividades cueva">
			<form method="POST" action="/cueva">
				<h2>Cueva</h2>
				<p>
					(Ganas entre 5 - 10 de <span class="orocolor">oro</span>)
				</p>
				<label for="cueva"></label>
				<button type="submit">¡Ir a la Cueva!</button>
			</form>
		</article>

		<article class="actividades casa">
			<form method="POST" action="/casa">
				<h2>Casa</h2>
				<p>
					(Ganas entre 2 - 5 de <span class="orocolor">oro</span>)
				</p>
				<label for="casa"></label>
				<button type="submit">¡Ir a la Casa!</button>
			</form>
		</article>

		<article class="actividades casino">
			<form method="POST" action="/casino">
				<h2>Casino</h2>
				<p>
					(Puedes ganar/<span class="perder">perder</span> 0 - 50 de <span
						class="orocolor">oro</span>)
				</p>
				<label for="casino"></label>
				<button class="rainbow rainbow-1" type="submit">¡Ir al
					Casino!</button>
			</form>
		</article>

		<article class="actividades spa">
			<form method="POST" action="/spa">
				<h2>Spa</h2>
				<p>
					(<span class="perder">Pierdes</span> 5 - 20 de <span
						class="orocolor">oro</span>)
				</p>
				<label for="spa"></label>
				<button class="" type="submit">¡Ir al Spa!</button>
			</form>
		</article>
	</main>
	<section class="actividad">
		<h1>Actividades</h1>

		<ul>
			<c:forEach var="register" items="${registro}">
				<li><c:choose>
						<c:when test="${register.contains('perdido')}">
							<span class="perder">${register}</span>
						</c:when>
						<c:otherwise>
							<c:out value="${register}" />
						</c:otherwise>
					</c:choose></li>
			</c:forEach>
		</ul>

	</section>

</body>
</html>