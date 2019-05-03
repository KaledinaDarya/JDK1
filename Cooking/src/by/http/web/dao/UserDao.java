package by.http.web.dao;

import java.util.List;

import by.http.web.entity.User;

public interface UserDao {

	List<User> readAll();
	void addUser(User user);
}
