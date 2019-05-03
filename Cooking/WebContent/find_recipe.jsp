<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find recipe</title>
</head>
<body>

Find recipe by title:
	<form action="UserActionsServlet" method="POST">

		<input type="hidden" name="action" value="find_recipe_by_title"/>
		
		<input type="text" name="recipeTitle"/>

		<input type="submit" value="find recipe"/>

	</form>

</body>
</html>