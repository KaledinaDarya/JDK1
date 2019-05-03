<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find book</title>
</head>
<body>

Find book by title:
	<form action="MySecondServlet" method="POST">

		<input type="hidden" name="action" value="find_book_by_title"/>
		
		<input type="text" name="book_title"/>

		<input type="submit" value="find book"/>

	</form>

</body>
</html>