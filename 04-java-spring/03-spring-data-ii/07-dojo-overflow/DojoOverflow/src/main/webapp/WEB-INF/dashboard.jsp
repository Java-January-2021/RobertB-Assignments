<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
	<div class = "containers">
	<h1>Questions Dashboard</h1>
	<table class = "table table - dark">
	<thead>
	<tr>
	<td>Question</td>
	<td>tags</td>
	</tr>
	</thead>
	<c:forEach items="${questions}" var="q">
	<tr>
	<td>${q.question}</td>
	<td>${q.tags.subject}</td>
	</tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>

