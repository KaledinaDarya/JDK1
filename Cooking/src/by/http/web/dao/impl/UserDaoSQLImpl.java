package by.http.web.dao.impl;

import static by.http.web.dao.utils.DaoConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.http.web.dao.UserDao;
import by.http.web.entity.User;

public class UserDaoSQLImpl implements UserDao{

	private static final String SQL_SELECT = "SELECT * FROM user";
	private static final String SQL_INSERT_INTO = "INSERT INTO user (right) VALUES (?)";

	@Override
	public List<User> readAll() {
		
		List<User> users = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(SQL_SELECT);
					
					User user = null;
					while (rs.next()) {
						user = new User(rs.getInt("id"), rs.getString("right"));
						users.add(user);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return users;
	}

	@Override
	public void addUser(User user) {
		
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_INTO, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getRight());
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
