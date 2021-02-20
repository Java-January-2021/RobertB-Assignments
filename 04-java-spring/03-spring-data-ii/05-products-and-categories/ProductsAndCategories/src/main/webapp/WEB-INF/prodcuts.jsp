<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1>
<p><c:out value="${product.description}"/></p>
<p><c:out value="${product.price}"/></p>

<h3>Categories</h3>
<ul>
<c:forEach items="${product.category}" var="pc">
<li>${pc.name}</li>
</c:forEach>
</ul>

<h3>Add a Category to ${product.name}</h3>
<form:form id ="inputForm" action="addCategoryToProduct/${product.id}" method="POST" modelAttribute="product">
<form:select class = "formInput" path="category" name="category">
<c:forEach items="${notInCategory}" var="nic">
<option value="${nic.id}">${nic.name}</option>
</c:forEach>
</form:select>
<button>Add Category!</button>
</form:form>

</body>
</html>