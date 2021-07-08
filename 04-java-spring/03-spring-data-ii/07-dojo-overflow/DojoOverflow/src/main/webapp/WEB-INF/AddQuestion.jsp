<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Create a Question</title>
</head>
<body>
<h1>What is your question?</h1>
<form:form id="inputForm" action="/addQuestion" method="POST" modelAttribute="questions">
<div class="formDiv">
<form:label class = "formLabel" path="question">Question</form:label>
<form:input class = "formInput" path="question"/>
</div>
<div class="formDiv">
<form:label class="formLabel" path="tags">Tags</form:label>
<form:input class = "formInput" path="tags"/>
</div>
<button>Submit</button>
</form:form>
</body>
</html>