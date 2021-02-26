<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Update Your Event!</h3>
	<form:form method="post" action="/update/${event.id}" modelAttribute="event">
	<form:input path="eventHost" value="${user_id}" type="hidden"/>
	<p>
	<form:label path ="name">Name:</form:label>
	<form:input path="name"/>
	<form:errors path="name"/>
	<p>
	
	<p>
	<form:label path ="date">Date:</form:label>
	<form:input type="date" path="date"/>
	<form:errors path="date"/>
	<p>
	
	<p>
	<form:label path ="city">city:</form:label>
	<form:input path="city"/>
	<form:errors path="city"/>
	<p>
	
	<p>
	<form:label path ="state">State:</form:label>
	<form:errors path="state"/>
	<form:select path="state">
	<c:forEach items="${states}" var = "state">
	<option value="${state}">${state}</option>
	</c:forEach>
	</form:select>
	<p>
	
	<button type="submit">Update Event!</button>
	</form:form>

</body>
</html>