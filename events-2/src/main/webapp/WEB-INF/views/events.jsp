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
<link rel="stylesheet" type="text/css" href="/css/events.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>Eventos</title>
</head>
<body>
		<nav class="navbar bg-body-tertiary" data-bs-theme="dark">
				<div class="container-fluid">
					<h1 class="navbar-brand"><i class="bi bi-house-door-fill"></i>
						Bienvenido, ${user.first_name} ${user.last_name} 
					</h1>
					<span class="navbar-text text-light">
						Aqui estan todos los proximos eventos
					</span>
					<a class="navbar-brand" href="/logout">Cerrar sesion <i class="bi bi-door-closed-fill"></i></a>
				</div>
		</nav>
		<main class="container-fluid table-responsive">
			<section class = "mt-5">
			<p class="text-center">Los eventos en tu estado:</p>
				<table class="table table-hover align-middle">
					<thead class ="table-dark">
						<tr>
							<th class="text-center">Nombre</th>
							<th class="text-center">Fecha</th>
							<th class="text-center">Ubicacion</th>
							<th class="text-center">Anfitrion</th>
							<th class="text-center">Accion / Estado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stateEvents}" var="event">
						<tr>
								<td class="text-center"><a href="/events/${event.id}">${event.name}</a></td>
								<td class="text-center">${event.date}</td>
								<td class="text-center">${event.location}</td>
								<td class="text-center">${event.user.first_name}</td>
								<td>
								 	<div class="d-flex justify-content-evenly align-items-center">
								<c:choose>
											<c:when test="${event.user.id == user.id}">
												<a href="/events/${event.id}/edit">Editar</a>
												<form action="/events/${event.id}/delete" method="post">
													<input type="hidden" name="_method" value="delete">
													<button class="eliminar" type="submit">Eliminar</button>
												</form>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${event.users.contains(user)}">
														<form action="/events/${event.id}/cancel" method="post">
														    <button class="eliminar" type="submit">Cancelar</button>
														</form>
													</c:when>
													<c:otherwise>
														<form action="/events/${event.id}/join" method="post">
															<button type="submit">Unirse</button>
														</form>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			<section class = "mt-5">
				<p class="text-center">Eventos en otros estados:</p>
				<table class="table table-hover align-middle">
					<thead class ="table-dark">
						<tr>
							<th class="text-center">Nombre</th>
							<th class="text-center">Fecha</th>
							<th class="text-center">Ubicacion</th>
							<th class="text-center">Estado</th>
							<th class="text-center">Anfitrion</th>
							<th class="text-center">Accion / Estado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${events}" var="event">
							<tr>
								<td class="text-center"><a href="/events/${event.id}">${event.name}</a>
								</td>
								<td class="text-center">${event.date}</td>
								<td class="text-center">${event.location}</td>
								<td class="text-center">${event.state}</td>
								<td class="text-center">${event.user.first_name}</td>
								<td class="text-center">
									<div class="d-flex justify-content-evenly align-items-center">
									<c:choose>
											<c:when test="${event.user.id == user.id}">
												<a href="/events/${event.id}/edit">Edit</a>
												<form action="/events/${event.id}/delete" method="post">
												    <input type="hidden" name="_method" value="delete">
												    <button class="eliminar" type="submit">Eliminar</button>
												</form>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${event.users.contains(user)}">
														<form action="/events/${event.id}/cancel" method="post">
														    <button class="eliminar" type="submit">Cancelar</button>
														</form>
													</c:when>
													<c:otherwise>
														<form action="/events/${event.id}/join" method="post">
															<button class="eliminar" type="submit">Unirse</button>
														</form>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			
			<div class="col d-flex flex-column align-items-center justify-content-center mt-2">
				<form:form class="d-flex flex-column col-5 align-items-center justify-content-center mt-2 " accept-charset="UTF-8" action="/events" method="POST" modelAttribute="event">
					<h1>Crea un evento</h1>
					<article class="row mb-3">
						<form:label path="name" class="col-sm-12 col-form-label text-center">Nombre del evento:</form:label>
						<form:input type="text" path="name" class="form-control"/>
						<div>
				   	 		<p>
								<form:errors path="name" />
							</p>
				    	</div>
					</article>
					
					<article class="row mb-3 text-center">
						<form:label path="date" class="col-sm-12 col-form-label text-center">Programa la fecha del evento:</form:label>
						<form:input type="date" path="date" id="date" name="date"  />
					</article>
					<form:errors path="date" />
					<article class="row mb-3">
				        <form:label path="location" class="col-sm-12 col-form-label text-center">Ubicacion:</form:label>
				        <form:input type="location" path="location" class="form-control"/>
				        
				        <form:label path="state" for="state" class="form-label">Estado</form:label>
				        <form:select path="state" class="form-select">
				            <c:forEach items="${states}" var="state">
				                <c:choose>
				                    <c:when test="${state == user.state}">
				                        <option value="${state}" selected>${state}</option>
				                    </c:when>
				                    <c:otherwise>
				                        <option value="${state}">${state}</option>
				                    </c:otherwise>
				                </c:choose>
				            </c:forEach>
				        </form:select>
				        <div>
				   	 		<p>
								<form:errors path="location" />
							</p>
				    	</div>
				    </article>
				
					<article>
						<input type="submit" class="btn btn-primary" value="Create" />
					</article>
				</form:form>
			</div>
		</main>
</body>
</html>