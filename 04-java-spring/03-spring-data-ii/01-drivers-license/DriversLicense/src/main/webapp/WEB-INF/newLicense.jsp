<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Add A License To A Person</title>
</head>
<body>
	<form:form method="POST" action="/addLicense" modelAttribute="license">
	<form:label path="person">First name
    <form:select class="form-control" path="person">
    <c:forEach items="${persons}" var="person">
    	<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
    </c:forEach>
    </form:select></form:label>
    
    <form:label path="state">State
    <form:input path="state"/></form:label>
    
    <form:label path="expiration_date">Expiration Date
    <form:input type ="Date" path="expiration_date"/></form:label>

    <input type="submit" value="Submit">
</form:form>
</body>
</html>