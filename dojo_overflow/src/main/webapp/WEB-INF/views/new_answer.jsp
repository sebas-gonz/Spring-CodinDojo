<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Answer</title>
<link rel="stylesheet" type="text/css" href="/css/new_answer.css">
</head>
<body>
	<header>
		<h1>${question.question}</h1>
		<h3>Tags: </h3>
		<c:forEach items="${tag}" var="tag">
			<h4>${tag.subject}</h4>
		</c:forEach>
	</header>
	<main>
		<table>
			<tr>
				<th>Answer</th>
			</tr>
			<c:forEach items="${question.answer}" var="answer">
			<tr>
					<td>${answer.answer}</td>
			</tr>
			</c:forEach>
		</table>
	</main>
	<section>
		<fieldset>
			<legend>Register question</legend>
			<div>
				<form:form accept-charset="UTF-8" action="/question/${question.id}" method="post" modelAttribute="reply">
					<form:label path="answer" for="answer">Answer: </form:label>
					<form:input id="answer" type="text" path="answer" />
					<form:errors path="answer" cssClass="error" />

					<p>
						<input type="submit" class="submit" value="Create" />
					</p>
				</form:form>
			</div>
		</fieldset>
	</section>
</body>
</html>