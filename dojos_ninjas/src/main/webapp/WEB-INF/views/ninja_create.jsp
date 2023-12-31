<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Register</title>
<link rel="stylesheet" type="text/css" href="/css/new_ninja.css">
</head>
<body>
	<main>
		<form:form accept-charset="UTF-8" action="/ninjas/new/add" method="post" modelAttribute="ninja">
			<fieldset>
				<legend>Personal Information</legend>
				<div>
					<label for="dojo">Dojos: </label> 
					<select name="dojo" id="dojo">
						<c:forEach items="${dojo}" var="dojo">
							<option value="${dojo.id}"> ${dojo.name}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<form:label path="firstName" for="firstName">Name:</form:label>
					<form:input type="text" path="firstName" />
					<form:errors path="firstName" cssClass="error" />
				</div>
				<div>
					<form:label path="lastName" for="lastName">Last Name:</form:label>
					<form:input type="text" path="lastName" />
					<form:errors path="lastName" />
				</div>
				<div>
					<form:label path="age" for="age">Age: </form:label>
					<form:input type="text" path="age" />
					<form:errors path="age" />
				</div>
			</fieldset>
			<p>
				<input type="submit" class="submit" value="Create" />
			</p>
		</form:form>
	</main>
</body>
</html>