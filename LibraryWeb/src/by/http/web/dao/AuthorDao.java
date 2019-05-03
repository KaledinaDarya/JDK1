package by.http.web.dao;

import java.util.List;

import by.http.web.entity.Author;

public interface AuthorDao {

	List<Author> readAll();
	void addAutor(Author author);
}
