<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form method="POST" action="/submit">
		<label>Your Name: <input type = "text" name = "name"></label>
		<label>Dojo Location: 
			<select name = "location" id="location">
				<c:forEach items = "${location}" var = "loc">
					<option value="<c:out value="${loc}"/>"><c:out value="${loc}"/></option>
				</c:forEach>
			</select>
		</label>
		<label>Language:
			<select name = "lang" id="lang">
				<c:forEach items = "${lang}" var = "lang">
					<option value="<c:out value="${lang}"/>"><c:out value="${lang}"/></option>
				</c:forEach>
			</select>
		</label>
		<label>Comment: <textarea name = "comment"></textarea></label>
		<button>Submit</button>
	</form>
	</div>
</body>
</html>