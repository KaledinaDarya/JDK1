package by.http.web.pattern;

import by.http.web.dao.RecipeDao;
import by.http.web.dao.UserDao;
import by.http.web.dao.impl.RecipeDaoSQLImpl;
import by.http.web.dao.impl.UserDaoSQLImpl;

public class SingletonDaoSql {

	private static SingletonDaoSql _instance = null;
	private static RecipeDao recipeDao;
	private static UserDao userDao;
	
	private SingletonDaoSql() {
		recipeDao = new RecipeDaoSQLImpl();
		userDao = new UserDaoSQLImpl();
	}

	public RecipeDao getRecipeDao() {
		return recipeDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	public static SingletonDaoSql getFactory() {
		if (_instance == null) {
			_instance = new SingletonDaoSql();
		}
		return _instance;
	}
}
