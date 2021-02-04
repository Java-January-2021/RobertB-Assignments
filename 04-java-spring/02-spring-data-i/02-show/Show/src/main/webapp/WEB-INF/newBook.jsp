<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Book</h1>
		<form method="POST" action="/createBook" >
			<label>Title: <input type="text" name="title"></label>
			<label>Description: <input type="text" name="description"></label>
			<label>Number of Pages <input type="number" name="numberOfPages"></label>
			<button>Submit!</button>
		</form>
</body>
</html>