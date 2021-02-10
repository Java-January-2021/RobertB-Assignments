<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing A Persons License</title>
</head>
<body>
<h3>${person.firstName} ${person.lastName}</h3>
<p>License number: ${person.license.number}</p>
<p>State: ${person.license.state}</p>
<p>Expiration Date: ${person.license.expiration_date}</p>
</body>
</html>