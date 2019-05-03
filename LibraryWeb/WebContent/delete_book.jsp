<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete book by id</title>
</head>
<body>

Add book:
	<form action="MySecondServlet" method="GET">

		<input type="hidden" name="action" value="delete_book_by_id"/>
		
		<input type="number" id="book_id"/>

		<input type="submit" value="delete book"/>

	</form>

</body>
</html>