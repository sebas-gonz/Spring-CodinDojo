<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/evento.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>${event.name}</title>
</head>
<body>
	<nav class="navbar bg-body-tertiary d-flex justify-content-between" data-bs-theme="dark">
				<div class="container-fluid d-flex justify-content-between">
		        	<a class="navbar-brand me-0" href="/events"><i class="bi bi-house-door-fill"></i> Inicio</a>
		        	<a class="navbar-brand ms-auto" href="/logout">Cerrar sesion <i class="bi bi-door-closed-fill"></i></a>>
		        </div>
	</nav>
	<main class="container-fluid">
			<section class="row d-flex justify-content-center">
				<div class = "col-md-6 d-flex flex-column justify-content-center align-items-center mt-2">
				<h1>${event.name}</h1>
					<article class="mb-3">
						<p>Anfitrion: ${event.user.first_name} ${event.user.last_name}</p>
						<p>Fecha: ${event.date}</p>
						<p><i class="bi bi-geo-alt"></i>  Ubicacion: ${event.location}, ${event.state}</p>
						<p><i class="bi bi-person"></i> Personas que asistirán al evento: ${event.users.size()}</p>
					</article>
					<table class="col-md-12 table table-borderless table-hover align-middle">
						<thead>
							<tr>
								<th class="text-center">Nombre</th>
								<th class="text-center">Ubicacion</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${event.users}">
								<tr>
									<td class="text-center">${user.first_name} ${user.last_name}</td>
									<td class="text-center">${user.location}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
				<div class = "col-md-6 d-flex flex-column justify-content-center align-items-center mt-2">
						<h2>Muro de mensajes:</h2>
						<ul class="list-group">
							<c:forEach var="comment" items="${comments}">
								<li class="list-group-item">${comment.user.first_name} ${comment.user.last_name}: ${comment.content}</li>
							</c:forEach>
						</ul>
						<h3>Añade un comentario:</h3>
						<form:form accept-charset="UTF-8" action="/events/${event.id}/comment" method="post" modelAttribute="comment">
							<article>
							<form:label class="form-label" path="content" for="comment"></form:label>
							<form:textarea class="form-control" path="content" name="content" id="comment"></form:textarea>
							</article>
							<p><form:errors path="content" /></p>
							<article>
								<input class="btn btn-primary" type="submit" value="Submit" />
							</article>
						</form:form>
					</div>
			</section>
	</main>
</body>
</html>