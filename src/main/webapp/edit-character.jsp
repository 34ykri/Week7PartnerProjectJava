<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your character.</title>
</head>
<body>
<h1>Edit Character - ${itemToEdit.characterName}</h1>
<form action="editCharacterServlet" method="post">
Character Name: <input type="text" name="name" value="${itemToEdit.characterName}">
Character Name: <input type="text" name="class" value="${itemToEdit.characterClass}">
Character Race: <input type="text" name="race" value="${itemToEdit.characterRace}">
Character Level: <input type="text" name="level" value="${itemToEdit.characterLevel}">
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Save Edited Item">
</form>

</body>
</html>