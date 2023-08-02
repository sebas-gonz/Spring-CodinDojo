<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Question</title>
<link rel="stylesheet" type="text/css" href="/css/new_question.css">
</head>
<body>
	<header>
		<h1>¿Whats is your question?</h1>
	</header>
	<main>
		<fieldset>
			<legend>Register question</legend>
			<form:form accept-charset="UTF-8" action="/question/new" method="post" modelAttribute="quest">
				<form:label path="question" for="quest">Question: </form:label>
				<form:input type="text" path="question" id="question" />
				<form:errors path="question" cssClass="error" />
				
                        <label for="tags">Tags: </label>
                        <input type="text" name="tags" id="tags" />

				<p>
					<input type="submit" class="submit" value="Create" />
				</p>
			</form:form>
		</fieldset>
	</main>
</body>
</html>