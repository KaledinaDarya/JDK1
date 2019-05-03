<%@ page language="java" contentType="text/html; ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add author</title>
</head>
<body>

Add author:
	<form action="MySecondServlet" method="POST">

		<input type="hidden" name="action" value="add_author"/>
		
		<input type="date" name="data"/>
		<input type="email" name="email"/>
		<input type="text" name="author_name"/>

		<input type="submit" value="add new author"/>

	</form>
</body>
</html>