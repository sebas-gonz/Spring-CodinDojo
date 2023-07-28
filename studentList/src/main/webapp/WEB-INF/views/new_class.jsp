<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Class</title>
<link rel="stylesheet" type="text/css" href="/css/new_class.css">
</head>
<body>
	<header>
		<nav>
			<a href="http://localhost:8080/">Home</a>
		</nav>
	</header>
	<main>
       <form:form accept-charset="UTF-8" action="/classes/new" method="post" modelAttribute="class">
            <fieldset>
                <legend>Register Classes</legend>
                <div>
                    <form:label path="name" for="name">Name: </form:label>
                    <form:input type="text" path="name" />
                    <form:errors path="name" cssClass="error" />
                </div>
            </fieldset>
            <p>
                <input type="submit" class="submit" value="Create"/>
            </p>
        </form:form>
    </main>
</body>
</html>