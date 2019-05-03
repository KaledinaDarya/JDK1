<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit recipe</title>
</head>
<body>

Edit recipe title:  
	<form action="UserActionsServlet" method="POST">

		<input type="hidden" name="action" value="edit_recipe_title"/>
		
		<input type="number" id="recipeId"/>
		
		<input type="text" name="recipeTitle"/>

		<input type="submit" value="edit recipe"/>
	</form>
	
Edit recipe description:  
	<form action="UserActionsServlet" method="POST">

		<input type="hidden" name="action" value="edit_recipe_description"/>
		
		<input type="number" id="recipeId"/>
		
		<input type="text" name="recipeDescription"/>

		<input type="submit" value="edit recipe"/>
	</form>
	
Edit recipe complexity:  
	<form action="UserActionsServlet" method="POST">

		<input type="hidden" name="action" value="edit_recipe_complexity"/>
		
		<input type="number" id="recipeId"/>
		
		<input type="text" name="recipeComplexity"/>

		<input type="submit" value="edit recipe"/>
	</form>
	
Edit recipe time:  
	<form action="UserActionsServlet" method="POST">

		<input type="hidden" name="action" value="edit_recipe_time"/>
		
		<input type="number" id="recipeId"/>
		
		<input type="text" name="recipeTime"/>

		<input type="submit" value="edit recipe"/>
	</form>
</body>
</html>