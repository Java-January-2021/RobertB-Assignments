<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Welcome ${user.name}</h1>
	<div class="table table-dark">
	<Table>
	<thead>
	<tr>
	<td>Idea</td>
	<td>Created By:</td>
	<td>Likes</td>
	<td>Action</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${ideas}" var="idea">
	<tr>
	<td><a href="/index/ideas/${idea.id}">${idea.content}</a></td>
	<td>
	${idea.ideaCreator.name}</td>
	
	<td><c:set var="count" value="0"/>
	${idea.usersLiked.size()}</td>
	<td>
	<c:choose>
	<c:when test="${idea.usersLiked.contains(user)}">
	<a href="/index/unlike/${idea.id}">unlike!</a>
	</c:when>
	<c:otherwise>
	<a href="/index/like/${idea.id}">Like!</a>
	</c:otherwise>
	</c:choose>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</Table>
	</div>
		<a href="/index/createIdea"> New Idea</a>
	</div>
</body>
</html>