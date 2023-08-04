<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<header>
		<a href="http://localhost:8080/dojos/new">Register</a> <a
			href="http://localhost:8080/ninjas/new">Ninja Register</a>
	</header>
	<form accept-charset="UTF-8" action="/" method="post">
		<label for="dojos">Dojos: </label> <select name="dojos" id="dojos">
			<c:forEach items="${dojos}" var="dojos">
				<option value="${dojos.id}">${dojos.name}</option>
			</c:forEach>
		</select> <input type="submit" class="submit" value="Search Dojo" />
	</form>
	<main>
		<fieldset>
			<c:forEach begin="0" end="${dojosninjas.totalPages - 1}" var="index">
				<a href="/${index + 1}">${index + 1}</a>
			</c:forEach>
			 <c:forEach items="${dojosninjas.content}" var="dojo">
  
            	<h2>Dojo: ${dojo.name}</h2>
            	<table>
                	<tr>
                    	<th>Ninja First name:</th>
                    	<th>Ninja Last name:</th>
                	</tr>
                	<c:forEach items="${dojo.ninjas}" var="ninja">
                    <tr>
                        <td>${ninja.firstName}</td>
                        <td>${ninja.lastName}</td>
                    </tr>
                </c:forEach>
            </table>
   		 </c:forEach>
		</fieldset>
	</main>
</body>
</html>