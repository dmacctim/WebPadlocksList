<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing List</title>
</head>
<body>
	<form action = "editListDetailsServlet" method="post">
		<input type ="hidden" name = "id" value= "${listToEdit.id}">
		List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
		Lockpicker Name: <input type = "text" name = "lockpickerName" value="${listToEdit.lockpicker.lockpickerName}"><br />
		Available Items:<br />
		<select name="allPadlocksToAdd" multiple size="6">
		<c:forEach items="${requestScope.allPadlocks}" var="currentpadlock">
			<option value = "${currentpadlock.id}">${currentpadlock.brand} ${currentpadlock.model}</option>
		</c:forEach>
		</select>
		<br />
		<input type = "submit" value="Edit List and Add Padlocks">
	</form>
	<a href = "index.html">Go add new padlocks instead.</a>
</body>
</html>