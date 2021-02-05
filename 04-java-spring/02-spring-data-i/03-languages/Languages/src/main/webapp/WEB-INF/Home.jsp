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
	<c:forEach items="${languages}" var="lang">
		<h4><c:out value="${lang.id}"></c:out></h4>
		<h1><a href="/language/${lang.id}"><c:out value="${lang.name}"></c:out></a></h1>
		<h2><c:out value="${lang.creator}"></c:out></h2>
		<h3><c:out value="${lang.currentVersion}"></c:out></h3>
		<p><a href="/language/delete/${lang.id}">Delete</a></p>
		<p><a href="/language/edit/${lang.id}">edit</a></p>
	</c:forEach> 
	<p> <a href="/add">add a language </a></p>
</body>
</html>