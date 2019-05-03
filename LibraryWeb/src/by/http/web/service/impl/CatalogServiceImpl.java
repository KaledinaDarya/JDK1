package by.http.web.service.impl;

import java.util.List;

import by.http.web.dao.AuthorDao;
import by.http.web.dao.BookDao;

import by.http.web.entity.Author;
import by.http.web.entity.Book;
import by.http.web.patterns.SingletonDaoSQL;
import by.http.web.service.CatalogService;

public class CatalogServiceImpl implements CatalogService {
	
	private static SingletonDaoSQL factory = SingletonDaoSQL.getFactory();
	
	private static BookDao bookDao = factory.getBookDao();		
	private static AuthorDao authorDao = factory.getAutorDao();	
	
	@Override
	public List<Book> getCatalogBooks() {
		return bookDao.readAll();
	}
	
	@Override
	public List<Author> getCatalogAuthors() {
		return authorDao.readAll();
	}

	@Override
	public void addAuthorToCatalog(String author_name) {
		Author author = new Author(author_name);
		authorDao.addAutor(author);
		System.out.println(authorDao.readAll());
	}

	@Override
	public void addBookToCatalog(String book_title) {
		Book book = new Book(book_title);
		bookDao.addBook(book);
		System.out.println(bookDao.readAll());
	}

	@Override
	public void deleteBookFromCatalog(long book_id) {
		bookDao.deleteBookById(book_id);
		System.out.println(bookDao.readAll());
	}

	@Override
	public void editBookFromCatalog(long book_id, String book_title) {
		bookDao.editBookById(book_id, book_title);
		System.out.println(bookDao.readAll());
	}

	@Override
	public List<Book> findBookFromCatalog(String book_title) {
		return bookDao.findBookByTitle(book_title);
	}

	@Override
	public List<Book> findBookFromCatalog(long book_id) {
		return bookDao.findBookById(book_id);
	}
}
