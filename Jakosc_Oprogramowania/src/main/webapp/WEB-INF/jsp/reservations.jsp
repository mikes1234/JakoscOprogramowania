<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservations List</title>
</head>
<body>
<h1>All Reservations</h1>
			<c:forEach var="listValue" items="${lists}">
				<ul>${listValue.getId()}, 
				${listValue.getFirstName()}</ul>
			</c:forEach>
</body>
</html>