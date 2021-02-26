<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<div class="nav-bar">
	<h2>Welcome, <c:out value="${user.firstName} ${user.lastName}"></c:out></h2> | <a href="/logout">Logout!</a>
	</div>
	<hr>
	<h4>Here are some events in your state</h4>
	<div class="table table-dark">
	<Table>
	<thead>
	<tr>
	<td>Name</td>
	<td>Date</td>
	<td>Location</td>
	<td>Host</td>
	<td>Action</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${userState}" var="us">
	<tr>
	<td><a href="show/${us.id}">${us.name}</a></td>
	<td>${us.date}</td>
	<td>${us.city}</td>
	<td>${us.eventHost.firstName}</td>
	<td>
	<c:choose>
	<c:when test="${us.usersAttending.contains(user)}">
	<p>Joining! <span> | </span> <a href="/unjoin/${us.id}"> Cancel</a></p>
	</c:when>
	<c:otherwise>
	<a href="/join/${us.id}">Join!</a>
	</c:otherwise>
	</c:choose>
	<c:if test="${us.eventHost.id == user.id}"><span> | </span>
	<a href="/deleteEvent/${us.id}"> delete!</a>
	<span> | </span><a href="update/${us.id}"> Edit!</a>
	</c:if>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</Table>
	</div>
	<hr>
	<h4>Here are some events in other states:</h4>
	<div class="table table-dark">
	<Table>
	<thead>
	<tr>
	<td>Name</td>
	<td>Date</td>
	<td>Location</td>
	<td>Host</td>
	<td>Action</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${nonUserState}" var="nus">
	<tr>
	<td><a href="/show/${nus.id}">${nus.name}</a></td>
	<td>${nus.date}</td>
	<td>${nus.city}</td>
	<td>${nus.eventHost.firstName}</td>
	<td>
	<c:choose>
	<c:when test="${nus.eventHost.id == user.id}">
	<a href="/deleteEvent/${nus.id}">delete!</a> <span> | </span>
	<a href="editEvent/${nus.id}">Edit!</a>
	</c:when>
	<c:when test="${nus.usersAttending.contains(user)}">
	<p>Joining! <span> | </span> <a href="/unjoin/${nus.id}"> Cancel</a></p>
	</c:when>
	<c:otherwise>
	<a href="/join/${nus.id}">Join!</a>
	</c:otherwise>
	</c:choose>
	
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</Table>
	</div>
	
	<h3>Create an Event!</h3>
	<form:form method="POST" action="/createEvent" modelAttribute="event">
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
	<form:select path="state">
	<c:forEach items="${states}" var = "state">
	<option value="${state}">${state}</option>
	</c:forEach>
	</form:select>
	<p>
	
	<button type="submit">Add Event!</button>
	</form:form>
	</div>
</body>
</html>