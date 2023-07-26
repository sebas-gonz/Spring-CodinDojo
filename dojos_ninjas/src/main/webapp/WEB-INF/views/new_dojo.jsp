<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Dojo</title>
<link rel="stylesheet" type="text/css" href="/css/new_dojo.css">
</head>
<body>
	    <main>
       <form:form accept-charset="UTF-8" action="/dojos/new" method="post" modelAttribute="dojo">
            <fieldset>
                <legend>Register</legend>
                <div>
                    <form:label path="name" for="name">Name:</form:label>
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