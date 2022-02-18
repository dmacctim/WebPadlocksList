<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Padlock</title>
</head>
<body>
	<form action="editPadlockServlet" method="post">
		Brand: <input type="text" name="brand" value="${padlockToEdit.brand}"><br><br>
		Model: <input type="text" name="model" value="${padlockToEdit.model}"><br><br>
		<label for="pins">Number of pins:</label>
		<select name="pins" id="pins">
			<option value="${padlockToEdit.numPins}">No change</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
		</select><br><br>
		<label for="securitypins">Has security pins:</label>
		<select name="securitypins" id="securitypins">
			<option value="${padlockToEdit.hasSecurityPins}">No change</option>
			<option value="true">Yes</option>
			<option value="false">No</option>
		</select>
		<input type="hidden" name="id" value="${padlockToEdit.id}">
		<input type="submit" value="Save Edited Padlock">
	</form>
</body>
</html>