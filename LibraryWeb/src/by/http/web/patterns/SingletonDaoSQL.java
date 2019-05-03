package by.http.web.patterns;

import by.http.web.dao.AuthorDao;
import by.http.web.dao.BookDao;
import by.http.web.dao.impl.AuthorDaoSQLImpl;
import by.http.web.dao.impl.BookDaoSQLImpl;

public class SingletonDaoSQL {

	private static SingletonDaoSQL _instance = null;
	private static AuthorDao authorDao;
	private static BookDao bookDao;
	
	private SingletonDaoSQL() {
		authorDao = new AuthorDaoSQLImpl();
		bookDao = new BookDaoSQLImpl();
	}
	
	public AuthorDao getAutorDao() {
		return authorDao;
	}
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public static SingletonDaoSQL getFactory() {
		if (_instance == null) {
			_instance = new SingletonDaoSQL();
		}
		return _instance;
	}
}
