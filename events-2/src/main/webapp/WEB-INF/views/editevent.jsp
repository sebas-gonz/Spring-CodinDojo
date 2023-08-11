<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Evento</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
			<nav class="navbar bg-body-tertiary d-flex justify-content-between" data-bs-theme="dark">
				<div class="container-fluid d-flex justify-content-between">
		        	<a class="navbar-brand me-0" href="/events"><i class="bi bi-house-door-fill"></i> Inicio</a>
		        	<a class="navbar-brand ms-auto" href="/logout">Cerrar sesion <i class="bi bi-door-closed-fill"></i></a>>
		        </div>
	    	</nav>
	<main class="col d-flex flex-column align-items-center justify-content-center mt-2">
		<form:form class="d-flex flex-column col-5 align-items-center justify-content-center mt-2 " accept-charset="UTF-8" action="/events/${event.id}/edit" method="POST" modelAttribute="event">
			<h1>${event.name}</h1>
			<h2>Editar Evento</h2>
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
					<input type="submit" class="btn btn-primary" value="Edit" />
				</article>
		</form:form>
	</main>
</body>
</html>