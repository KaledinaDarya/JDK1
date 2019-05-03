<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add book</title>
</head>
<body>

Add book:
	<form action="MySecondServlet" method="POST">

		<input type="hidden" name="action" value="add_book"/>
		
		<input type="text" name="book_title"/>

		<input type="submit" value="add new book"/>

	</form>

</body>
</html>