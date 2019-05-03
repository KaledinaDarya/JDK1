package by.http.web.service;

import java.util.List;

import by.http.web.entity.Author;
import by.http.web.entity.Book;

public interface CatalogService {

	List<Book> getCatalogBooks();
	List<Author> getCatalogAuthors();
	
	void addAuthorToCatalog(String name);
	void addBookToCatalog(String title);
	
	void deleteBookFromCatalog(long id);
	
	void editBookFromCatalog(long id, String title);
	
	List<Book> findBookFromCatalog(long id);
	List<Book> findBookFromCatalog(String title);
}
