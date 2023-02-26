<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View your characters</title>
</head>
<body>
<h1>My Characters</h1>
<form method="post" action="navigationServlet">
<table>
<tr>
	<th></th>
	<th>Name</th>
	<th>Class</th>
	<th>Race</th>
	<th>Level</th>
</tr>
<c:forEach items="${requestScope.allCharacters}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.characterName}</td>
<td>${currentitem.characterClass}</td>
<td>${currentitem.characterRace}</td>
<td>${currentitem.characterLevel}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
<input type="submit" value="add" name="doThisToItem">
</form>
<a href="viewAllCharactersServlet">View all Characters</a>
<a href="viewAllTeamsServlet">View all Teams</a>
<a href="addCharactersForTeamServlet">Create a Team</a>

</body>
</html>