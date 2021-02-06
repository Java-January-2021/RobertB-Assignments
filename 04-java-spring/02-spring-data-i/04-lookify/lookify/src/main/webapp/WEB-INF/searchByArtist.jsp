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
<form action="/search">
<input type="text" name="artist"></input>
<button>New Seach</button>
</form>
<h3>Songs by <c:out value="${artist}"></c:out></h3>
<div class="container">
<table class="table">
<c:forEach items="${lookify}" var="look">
<thead>
<tr>
<td>title</td>
<td>rating</td>
</tr>
</thead>
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