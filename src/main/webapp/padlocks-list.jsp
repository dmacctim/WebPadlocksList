<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Padlocks List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allPadlocks}" var="currentpadlock">
				<tr>
					<td><input type="radio" name="id" value="${currentpadlock.id}"></td>
					<td>${currentpadlock.brand}&nbsp;&nbsp;</td>
					<td>${currentpadlock.model}&nbsp;&nbsp;</td>
					<td># of pins: ${currentpadlock.numPins}&nbsp;&nbsp;</td>
					<td>Has security pins: ${currentpadlock.hasSecurityPins}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem">
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>