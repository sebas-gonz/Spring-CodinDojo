<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
    <h1>Register!</h1>
    
    
    <form:form accept-charset="UTF-8"  method="POST" action="/" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
             <p><form:errors path="email"/></p>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <p><form:errors path="password"/></p>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
            <p><form:errors path="passwordConfirmation"/></p>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
    
</body>
</html>