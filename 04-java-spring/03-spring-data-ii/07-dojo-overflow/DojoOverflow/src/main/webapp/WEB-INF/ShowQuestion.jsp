<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${question.question}</h1>
<h3><c:forEach var="tag" items="${questions.tags}"><span class="tag">(${tag.subject})</span></c:forEach></h3>

<table>
    <tr><th>Answers</th></tr>
    <c:forEach items="${question.answers}" var="ans">
        <tr><td>${ans.answers}</td></tr>
    </c:forEach>
</table>

<form:form modelAttribute="answers" method="post" action="/questions/${question.id}">
    <form:label path="answer">
        Answer Question:<br>
        <form:errors path="answer"/>
        <form:textarea path="answer" rows="4" cols="30"/>
    </form:label>
    <button>Answer</button>
</form:form>
<a href="/">Dashboard</a>
</body>
</html>