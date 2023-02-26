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
<input type="hidden" name="id" value="${teamToEdit.id}">
Team Name: <input type="text" name="listName" value="${teamToEdit.listName}"><br/>

Creation date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
			<input type="text" name="day" placeholder="dd" size="4" value="${date}">
			<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
			
Creator Name: <input type="text" name="creatorName" value="${teamToEdit.creator.creatorName}"><br/>

Available teams:<br/>
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.store} | ${currentitem.item}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Edit List and Add Items">

</form>
<a href="index.html">Go add a new team instead.</a>

</body>
</html>