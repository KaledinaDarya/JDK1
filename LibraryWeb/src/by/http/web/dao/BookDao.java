package by.http.web.dao;

import java.util.List;

import by.http.web.entity.Book;

public interface BookDao {

	List<Book> readAll();
	void addBook(Book book);
	void deleteBookById(long id);
	void editBookById(long id, String title);
	List<Book> findBookById(long id);
	List<Book> findBookByTitle(String title);
}
