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
<a href="/"> Dashboard</a>
	<p><c:out value="${Language.id}"></c:out></p>
	<p><c:out value="${Language.name}"></c:out></p>
	<p><c:out value="${Language.creator}"></c:out></p>
	<p><c:out value="${Language.currentVersion}"></c:out></p>
</body>
</html>