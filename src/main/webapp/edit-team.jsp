<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an existing team.</title>
</head>
<body>
<form action = "editTeamServlet" method="post">
<input type="hidden" name="id" value="${editTeam.id}">
Team Name: <input type="text" name="listName" value="${editTeam.listName}"><br/>

Creation Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
			<input type="text" name="day" placeholder="dd" size="4" value="${day}">
			<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
			
Creator Name: <input type="text" name="name" value="${editTeam.creator.name}"><br/>

Available Characters:<br/>
<select name="allCharacters" multiple size="6">
<c:forEach items="${requestScope.allCharacters}" var="currentchar">
<option value = "${currentchar.id}">${currentchar.characterName}, ${currentchar.characterClass}, ${currentchar.characterLevel}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Edit Team and Add Characters">

</form>
<a href="index.html">Go add a new team instead.</a>

</body>
</html>