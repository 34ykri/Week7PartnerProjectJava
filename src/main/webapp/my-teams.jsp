<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character Teams</title>
</head>
<body>
<form method="post" action= "teamNavigationServlet">
<h1>My Teams</h1>
<table>
<c:forEach items="${requestScope.allTeams}" var="currentteam">
<tr>
<td><input type="radio" name="id" value="${currentteam.id}"></td>
<td><h2>${currentteam.listName}</h2></td>
<tr><td colspan="3">Creation Date: ${currentteam.dateCreated}</td></tr>
<tr><td colspan="3">Creator:
${currentteam.creator.name}</td></tr>
<tr><td>Characters:</td></tr>
<c:forEach var= "character" items = "${currentteam.charactersList}">
<tr><td colspan="3">
	     ${character.characterName}, ${character.characterClass}, ${character.characterLevel}</td></tr>
	</c:forEach>
	</c:forEach></table>
	<input type="submit" value="edit" name="doThisToTeam">
	<input type="submit" value ="delete" name="doThisToTeam">
	<input type="submit" value = "add" name= "doThisToTeam">
	</form>
	<a href="viewAllCharactersServlet">View all Characters</a>
	<a href="addCharactersForTeamServlet">Create a new team</a>
	<a href="index.html">Insert a new character</a>

</body>
</html>