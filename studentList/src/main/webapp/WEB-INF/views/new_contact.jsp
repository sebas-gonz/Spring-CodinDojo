<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Contact</title>
<link rel="stylesheet" type="text/css" href="/css/contact.css">
</head>
<body>
    <main>
       <form:form accept-charset="UTF-8" action="/contact" method="post" modelAttribute="contact">
            <fieldset>
                <legend>Contact info</legend>
                <div>
						<label for="student">Student: </label>
						<select name="student" id="student">
							<c:forEach items="${student}" var="student">
								<option value="${student.id}">${student.firstName} ${student.lastName}</option>
							</c:forEach>
						</select>
				</div>
                <div>
                    <form:label path="address" for="address">Address: </form:label>
                    <form:input type="text" path="address" />
                    <form:errors path="address" cssClass="error" />
                </div>
                <div>
                    <form:label path="city" for="city">City: </form:label>
                    <form:input type="text" path="city" />
                    <form:errors path="city"/>
                </div>
                <div>
                    <form:label path="state" for="state">State: </form:label>
                    <form:input type="text" path="state" />
                    <form:errors path="state"/>
                </div>
            </fieldset>
            <p>
                <input type="submit" class="submit" value="Create"/>
            </p>
        </form:form>
    </main>
</body>
</html>