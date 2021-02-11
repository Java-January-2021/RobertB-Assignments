<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Add A New Dojo</title>
</head>
<body>
<h3>New Dojo</h3>
<form:form method="POST" action="/add" modelAttribute="dojos">
	<form:label path="name">Dojo Name
    <form:input path="name"/></form:label>


    <input type="submit" value="Create">
</form:form>
</body>
</html>