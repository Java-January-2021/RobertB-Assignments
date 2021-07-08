<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Edit ${ideas.content}</h1>
	<form:form method="post" action="/index/edit/${ideas.id}" modelAttribute="ideas">
	<form:input path="ideaCreator" value="${user_id}" type="hidden"/>
	<form:input path="usersLiked" value="${user_id}" type="hidden"/>
	<p>
	<form:label path="content">Content:</form:label>
	<form:input path="content"/>
	<form:errors path="content"/>
	</p>
	<button>Update!</button>
	</form:form>
	<a href="/index/delete/${ideas.id}">Delete!</a>
	
	
	
	</div>
</body>
</html>