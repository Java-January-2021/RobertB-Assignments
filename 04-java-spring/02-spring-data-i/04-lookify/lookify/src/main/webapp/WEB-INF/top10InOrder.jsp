<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<div class="container">
<table class="table">
<c:forEach items="${lookify}" var="look">
<thead>
<tr>
<td>title</td>
<td>artist</td>
<td>rating</td>
</tr>
</thead>
	<tr>
	<td><a href="/dashboard/${look.id}">${look.title}</a></td>
	<td>${look.artist}</td>
	<td>${look.rating}</td>
	</tr>
</c:forEach>
</table>
</div>

</html>