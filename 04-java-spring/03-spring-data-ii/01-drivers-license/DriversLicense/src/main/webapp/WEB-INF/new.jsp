<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Add A New Person</title>
</head>
<body>
<h3>New Person</h3>
<form:form method="POST" action="/add" modelAttribute="persons">
	<form:label path="firstName">First name
    <form:input path="firstName"/></form:label>
    
    <form:label path="lastName">Last Name
    <form:input path="lastName"/></form:label>

    <input type="submit" value="Submit">
</form:form>
</body>
</html>