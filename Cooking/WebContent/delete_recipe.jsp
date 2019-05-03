<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete recipe</title>
</head>
<body>

Delete recipe by id:
	<form action="UserActionsServlet" method="GET">

		<input type="hidden" name="action" value="delete_recipe"/>
		
		<input type="number" id="recipeId"/>

		<input type="submit" value="delete recipe"/>

	</form>

</body>
</html>