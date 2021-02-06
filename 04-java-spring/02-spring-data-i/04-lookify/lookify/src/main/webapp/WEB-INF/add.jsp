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
<a href="/dashboard">Dashboard</a>
	<form:form method="POST" action="/add" modelAttribute="lookify">
	<form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    
    <form:label path="artist">Artist
    <form:errors path="artist"/>
    <form:input path="artist"/></form:label>
    
    <form:label path="rating">Rating
    <form:errors path="rating"/>
    <form:input path="rating"/></form:label>
    
    <input type="submit" value="Submit">
	</form:form>
	
</body>
</html>