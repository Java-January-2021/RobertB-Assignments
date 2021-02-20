<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Add A New Product</title>
</head>
<body>
<h3>New Product</h3>
<form:form id="inputForm" action="/createProduct" method="post" modelAttribute="products">
<form:label class="formLabel" path="name">Name</form:label>
<form:input class="formInput" path="name"></form:input>

<form:label class="formLabel" path="description">Description</form:label>
<form:input class="formInput" path="description"></form:input>

<form:label class="formLabel" path="price">Price</form:label>
<form:input type="number" step="any" class="formInput" path="price"></form:input>

<button>Add Product</button>
</form:form>
</body>