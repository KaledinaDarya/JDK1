<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit book</title>
</head>
<body>

Edit book:
	<form action="MySecondServlet" method="POST">

		<input type="hidden" name="action" value="edit_book_title_by_id"/>
		
		<input type="number" id="book_id"/>
		
		<input type="text" name="book_title"/>

		<input type="submit" value="edit book"/>

	</form>

</body>
</html>