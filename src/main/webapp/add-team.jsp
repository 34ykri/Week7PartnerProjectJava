<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Team</title>
</head>
<body>
<form action="createNewTeamServlet" method="post">
Team Name: <input type="text" name ="listName"><br/>
Creation Date: <input type="text" name="month" placeholder="mm" size="4">
			<input type="text" name="day" placeholder="dd" size="4">
			<input type="text" name="year" placeholder="yyyy" size="4">
Creator Name: <input type="text" name="creator"><br/>
Available Characters:<br/>
<select name="allCharactersToAdd" multiple size="6">
<c:forEach items="${requestScope.allCharacters}" var="currentchar">
<option value = "${currentchar.id}">${currentchar.characterName}, ${currentchar.characterClass}, ${currentchar.characterLevel}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Create Team and Add Characters">
</form>
<a href="index.html">Go add new characters instead.</a>
</body>
</html>