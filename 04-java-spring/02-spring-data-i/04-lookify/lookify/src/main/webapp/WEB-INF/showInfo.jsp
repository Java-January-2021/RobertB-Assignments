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
<a href="/">Dashboard</a>
<p><c:out value="${lookify.title}"></c:out></p>
<p><c:out value="${lookify.artist}"></c:out></p>
<p><c:out value="${lookify.rating}"></c:out></p>
<a href="/dashboard/delete/${lookify.id}"> delete</a>
</body>
</html>