<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/books" method="post"  modelAttribute="book">
	    <p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input type="text" path="book.title" placeholder="Enter the book title"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="book.description"/>
	    </p>
	    <p>
	        <form:label path="language">Language</form:label>
	        <form:errors path="language"/>
	        <form:input path="book.language"/>
	    </p>
	    <p>
	        <form:label path="numberOfPages">Pages</form:label>
	        <form:errors path="numberOfPages"/>     
	        <form:input type="number" path="book.numberOfPages"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form>    
</body>
</html>