<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/register.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<nav class="navbar bg-body-tertiary" data-bs-theme="dark">
		<div class="container-fluid">
			<h1 class="navbar-brand">Bienvenido</h1>
		</div>
	</nav>
	
	<main class="container-fluid">
		<div class="row d-flex justify-content-center">
			<div class="col d-flex flex-column justify-content-center align-items-center mt-2">
				<h1>Registrarse</h1>
				<form:form class="col-6" accept-charset="UTF-8" action="/register" method="POST" modelAttribute="user">
				  <div class="col-md-12 position-relative">
				    <form:label path="first_name"  for="first_name" class="form-label">Nombre: </form:label>
				    <form:input path="first_name" type="text" class="form-control" id="first_name"></form:input>
				    <div>
				    <p>
				      <form:errors path="first_name" />
				     </p>
				    </div>
				    
				  </div>
				  <div class="col-md-12 position-relative">
				    <form:label path="last_name" for="last_name" class="form-label">Apellido: </form:label>
				    <form:input path="last_name" type="text" class="form-control" id="last_name" ></form:input>
				    <div>
				      <p>
				      <form:errors path="last_name" />
				      </p>
				    </div>
				    
				  </div>
				  <div class="col-md-12 position-relative">
				    <form:label path="email" for="email" class="form-label">Correo electronico</form:label>
				    <div class="input-group ">
				      <form:input type="email" path="email" class="form-control" id="email" ></form:input>
				      <div>
				      <p>
				        <form:errors path="email" />
				        </p>
				      </div>
				    </div>
				  </div>
				  
				  <div class="col-md-12 position-relative">
				    <form:label path="location" for="location" class="form-label">Ubicacion</form:label>
				    <form:input path="location" type="text" class="form-control" id="location" ></form:input>
				    <div>
				    <p>
				      <form:errors path="location" />
				    </p>
				    </div>
				    
				  </div>
				  <div class="col-md-6 position-relative">
				    <form:label path="state" for="state" class="form-label">Estado</form:label>
				    <form:select path="state" class="form-select" id="state" >
					      <option selected disabled value="">Elige un estado</option>
					      <c:forEach items="${states}" var="state">
					      	<option value="${state}">${state}</option>
					     </c:forEach>
				    </form:select>
				  </div>
				  
				  <div class="col-md-5 position-relative">
				    <form:label path="password" for="password" class="form-label">Contraseña</form:label>
				    <form:input path="password" type="password" class="form-control" id="password" ></form:input>
				    <div>
				    <p>
				      <form:errors path="password" />
				     </p>
				    </div>
				  </div>
				  
				  <div class="col-md-5 position-relative">
				    <form:label path="passwordConfirmation" for="passwordConfirmation" class="form-label">Confirmar contraseña</form:label>
				    <form:input path="passwordConfirmation" type="password" class="form-control" id="passwordConfirmation" ></form:input>
				    <div>
				    <p>
				      <form:errors path="passwordConfirmation" />
				      </p>
				    </div>
				  </div>
				  
				  <div class=" mt-2">
				    <button class="btn btn-primary" type="submit">Registarse</button>
				  </div>
				</form:form>
			</div>
			
			<div class="col d-flex flex-column align-items-center mt-2">
				<h1>Iniciar Sesion</h1>
				<form class="col-6"  accept-charset="UTF-8" action="/login" method="POST">
					<div class="row mb-3">
					    <label for="email" class="col-sm-2 col-form-label">Correo electronico</label>
					    <div class="row-col-sm-3">
					      <input type="email" class="form-control" id="email" name="email">
					    </div>
					  </div>
					  
					  <div class="row mb-3">
					    <label for="password" class="col-sm-2 col-form-label">Contraseña</label>
					    <div class="row-col-sm-3">
					      <input type="password" class="form-control" id="inputPassword3" name="password">
					     	<p>
								<c:out value="${error}" />
							</p>
					    </div>  
					  </div>
					  <button type="submit" class="btn btn-primary">Iniciar Sesion</button>
				</form>
			</div>
		</div>
	</main>

</body>
</html>