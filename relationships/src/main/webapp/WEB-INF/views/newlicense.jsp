<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create License</title>
<link rel="stylesheet" type="text/css" href="/css/newlicense.css">
</head>
<body>
	<header>
		<a href="http://localhost:8080/">Index</a>
	</header>
	<main>
		<form:form accept-charset="UTF-8" action="/licenses" method="post"
			modelAttribute="license">
			<fieldset>
				<legend>Personal Information</legend>
				<div>
						<label for="person">Person: </label>
						<select name="person" id="person">
							<c:forEach items="${person}" var="person">
								<option value="${person.id}">${person.firstName} ${person.lastName}</option>
							</c:forEach>
						</select>
				</div>
				<div>
					<form:label path="state" for="state">State: </form:label>
					<form:input type="text" path="state" />
					<form:errors path="state" cssClass="error" />
				</div>
				<div>
					<form:label path="expirationDate" for="expirationDate">Expiration Date: </form:label>
					<form:input type="date" path="expirationDate" id="expirationDate" name="expirationDate"/>
					<form:errors path="expirationDate" />
				</div>
			</fieldset>
			<p>
				<input type="submit" class="submit" value="Create" />
			</p>
		</form:form>
	</main>
</body>
</html>