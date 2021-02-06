<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<a href="/add">Add new song</a>
<a href="/topsongs">top songs</a>
<form action="/search">
<input type="text" name="artist"></input>
<button>submit</button>
</form>
<table class="table">
<thead>
<tr>
<td>Title</td>
<td>Rating</td>
</tr>
</thead>
	<c:forEach items="${lookify}" var="look">
		<tr>
			<td><a href="/dashboard/${look.id}">${look.title}</a></td>
			<td>${look.rating}</td>
			<td> <a href = "/dashboard/delete/${look.id}">delete</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>