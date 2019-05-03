<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add recipe</title>
</head>
<body>

Add recipe:
	<form action="UserActionsServlet" method="POST">

		<input type="hidden" name="action" value="add_recipe"/>
		
		<input type="text" name="recipe_title"/>
		
		<input type="text" name="recipe_description"/>
		
		<input type="text" name="recipe_complexity"/>
		
		<input type="text" name="recipe_time"/>
		
		<input type="text" name="recipe_image_name"/>
		
		<input type="checkbox" name="recipe_flag_visible"/>
		
		<input type="submit" value="add new recipe"/>

	</form>
</body>
</html>