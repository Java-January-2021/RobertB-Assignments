<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Add A New Category</title>
</head>
<body>
<h3>New Category</h3>
<form:form id="inputForm" action="/createCategory" method="post" modelAttribute="categories">
<form:label class="formLabel" path="name">Name</form:label>
<form:input class="formInput" path="name"></form:input>

<button>Add Category</button>
</form:form>
</body>