<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/main.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1><c:out value="${event.name}"/></h1>
<p>Host: <c:out value="${event.eventHost.firstName} ${event.eventHost.lastName}"/></p>
<p>Date: <c:out value="${event.date}"/></p>
<p>Location: <c:out value="${event.city} ${event.state}"/></p>
<p>Number of users attending this gathering: <c:out value="${event.usersAttending.size()}"/></p>
<hr>

<h3>Wall Messages!</h3>
<div class="event-messages">
<c:forEach items="${event.messages}" var="e">
<p>${e.messageCreator.firstName} ${e.messageCreator.lastName} says: ${e.content}</p>
</c:forEach>


</div>
<form:form method="POST" action="/addMessage/${event.id}" modelAttribute="message">
	<form:input path="messageCreator" value="${user_id }" type="hidden"/>
	<p>
	<form:label path ="content">Message:</form:label>
	<span>${errors}</span>
	<form:input path="content"/>

	<p>
	
	<button type="submit">Add Message!</button>
	</form:form>
</div>
</body>
</html>