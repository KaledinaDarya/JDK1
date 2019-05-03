package by.http.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.http.web.dao.AuthorDao;
import by.http.web.entity.Author;

import static by.http.web.dao.utils.DaoConstants.*;

public class AuthorDaoSQLImpl implements AuthorDao{

	private static final String SQL_SELECT = "SELECT * FROM author";
	private static final String SQL_INSERT_INTO = "INSERT INTO author (name) VALUES (?)";
	
	@Override
	public List<Author> readAll() {
		
		List<Author> authors = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(SQL_SELECT);
					
					Author author = null;
					while (rs.next()) {
						author = new Author(rs.getInt("id"), rs.getString("name"));
						authors.add(author);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return authors;
	}

	@Override
	public void addAutor(Author author) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_INTO, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, author.getName());
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
}
