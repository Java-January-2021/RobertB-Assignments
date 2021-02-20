<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
<h1><c:out value="${category.name}"/></h1>


<h3>Categories</h3>
<ul>
<c:forEach items="${category.product}" var="cp">
<li>${cp.name}</li>
</c:forEach>
</ul>

<h3>Add a Product to ${category.name}</h3>
<form:form id ="inputForm" action="addProductToCategory/${category.id}" method="POST" modelAttribute="category">
<form:select class = "formInput" path="product" name="product">
<c:forEach items="${notInProduct}" var="nic">
<option value="${nic.id}">${nic.name}</option>
</c:forEach>
</form:select>
<button>Add Product!</button>
</form:form>


</body>
</html>