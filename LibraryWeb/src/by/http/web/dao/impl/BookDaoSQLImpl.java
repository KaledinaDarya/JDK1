package by.http.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.http.web.dao.BookDao;
import by.http.web.entity.Book;

import static by.http.web.dao.utils.DaoConstants.*;

public class BookDaoSQLImpl implements BookDao {

	private static final String SQL_SELECT = "SELECT * FROM book";
	private static final String SQL_SELECT_BY_TITLE = "SELECT * FROM book WHERE (title) VALUES (?)";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM book WHERE (id) VALUES (?)";
	
	private static final String SQL_INSERT_INTO = "INSERT INTO book (title) VALUES (?)";
	
	private static final String SQL_DELETE = "DELETE FROM book WHERE (id) VALUES (?)";
	
	private static final String SQL_EDIT = "UPDATE book SET title = VALUES (?) WHERE (id) = VALUES (?)";
	
	@Override
	public List<Book> readAll() {
		
		List<Book> books = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(SQL_SELECT);
			
					Book book = null;
					while (rs.next()) {
						book = new Book(rs.getInt("id"), rs.getString("title"));
						books.add(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_INTO, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, book.getTitle());
				ps.executeUpdate();
				
				ResultSet rs = ps.getGeneratedKeys();
				
				long key = 0;
				if (rs.next()) {
					key = rs.getLong(1);
				}
				System.out.println("key: " + key);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}	
	}

	@Override
	public void deleteBookById(long id) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);
				ps.setLong(1, id);
				ps.executeUpdate();
				
				System.out.println("The book is removed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}	
	}

	@Override
	public void editBookById(long id, String title) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_EDIT);
				ps.setString(1, title);
				ps.setLong(2, id);
				ps.executeUpdate();
				
				System.out.println("DB update");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
	}

	@Override
	public List<Book> findBookByTitle(String title) {
		
		List<Book> books = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_TITLE);
					ps.setString(1, title);
					ResultSet rs = ps.executeQuery();
			
					Book book = null;
					while (rs.next()) {
						book = new Book(rs.getInt("id"), rs.getString("title"));
						books.add(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> findBookById(long id) {
		
		List<Book> books = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID);
					ps.setLong(1, id);
					ResultSet rs = ps.executeQuery();
			
					Book book = null;
					while (rs.next()) {
						book = new Book(rs.getInt("id"), rs.getString("title"));
						books.add(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return books;
	}
}
