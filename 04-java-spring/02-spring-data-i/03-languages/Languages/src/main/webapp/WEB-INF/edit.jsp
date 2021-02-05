<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/"> Dashboard</a>
<p><a href="/language/delete/${id}">Delete</a></p>
	<form:form method="POST" action="/language/edit/${id}" modelAttribute="languages">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    
    <form:label path="creator">Creator
    <form:errors path="creator"/>
    <form:textarea path="creator"/></form:label>
    
    <form:label path="currentVersion">Current Version
    <form:errors path="currentVersion"/>
    <form:input path="currentVersion"/></form:label>
    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>