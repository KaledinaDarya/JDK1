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

import by.http.web.dao.RecipeDao;
import by.http.web.entity.Recipe;

public class RecipeDaoSQLImpl implements RecipeDao{
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM recipe";
	private static final String SQL_SELECT_VISIBLE = "SELECT * FROM recipe WHERE flag_visible = 1";
	
	private static final String SQL_SELECT_BY_TITLE = "SELECT * FROM recipe WHERE (title) VALUES (?) AND flag_visible = 1";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM recipe WHERE (id) VALUES (?) AND flag_visible = 1";
	
	private static final String SQL_INSERT_INTO = "INSERT INTO recipe (title, description, complexity, time, image_name, flag_visible) VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_EDIT_TITLE = "UPDATE recipe SET title = VALUES (?) WHERE (id) = VALUES (?)";
	private static final String SQL_EDIT_DESCRIPTION = "UPDATE recipe SET description = VALUES (?) WHERE (id) = VALUES (?)";
	private static final String SQL_EDIT_COMPLEXITY = "UPDATE recipe SET complexity = VALUES (?) WHERE (id) = VALUES (?)";
	private static final String SQL_EDIT_TIME = "UPDATE recipe SET time = VALUES (?) WHERE (id) = VALUES (?)";
	private static final String SQL_EDIT_IMAGE_NAME = "UPDATE recipe SET image_name = VALUES (?) WHERE (id) = VALUES (?)";
	private static final String SQL_EDIT_FLAG_VISIBLE = "UPDATE recipe SET flag_visible = VALUES (?) WHERE (id) = VALUES (?)";
	
	private static final String SQL_DELETE = "DELETE FROM recipe WHERE (id) VALUES (?)";

	@Override
	public List<Recipe> readAll() {

		List<Recipe> recipes = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
			
					Recipe recipe = null;
					while (rs.next()) {
						recipe = new Recipe(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("complexity"),
								rs.getInt("time"), rs.getString("image_name"), rs.getBoolean("flag_visible"));
						recipes.add(recipe);	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return recipes;
	}
	
	@Override
	public List<Recipe> readAllVisibleRecipes() {

		List<Recipe> recipes = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(SQL_SELECT_VISIBLE);
			
					Recipe recipe = null;
					while (rs.next()) {
						recipe = new Recipe(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("complexity"),
								rs.getInt("time"), rs.getString("image_name"), rs.getBoolean("flag_visible"));
						recipes.add(recipe);	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return recipes;
	}

	@Override
	public void addRecipe(Recipe recipe) {
		
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_INTO, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, recipe.getTitle());
				ps.setString(2, recipe.getDescription());
				ps.setLong(3, recipe.getComplexity());
				ps.setLong(4, recipe.getTime());
				ps.setString(5, recipe.getImageName());
				ps.setBoolean(6, recipe.isFlagVisible());
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
	public List<Recipe> findRecipeByTitle(String title) {

		List<Recipe> recipes = new ArrayList<>();
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_TITLE);
					ps.setString(1, title);
					ResultSet rs = ps.executeQuery();
			
					Recipe recipe = null;
					while (rs.next()) {
						recipe = new Recipe(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("complexity"),
								rs.getInt("time"), rs.getString("image_name"), rs.getBoolean("flag_visible"));
						recipes.add(recipe);	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return recipes;
	}

	@Override
	public Recipe findRecipeById(long id) {
		
		Recipe recipe = null;
		
		try {
				Class.forName(CLASS_NAME);
		
				try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
			
					PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID);
					ps.setLong(1, id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						recipe = new Recipe(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("complexity"),
								rs.getInt("time"), rs.getString("image_name"), rs.getBoolean("flag_visible"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		return recipe;
	}
	
	@Override
	public void editRecipeTitle(long id, String title) {
		editRecipeString(SQL_EDIT_TITLE, title, id);
	}

	@Override
	public void editRecipeDescription(long id, String description) {
		editRecipeString(SQL_EDIT_DESCRIPTION, description, id);
	}

	@Override
	public void editRecipeComplexity(long id, long complexity) {
		editRecipeLong(SQL_EDIT_COMPLEXITY, complexity, id);
	}

	@Override
	public void editRecipeTime(long id, long time) {
		editRecipeLong(SQL_EDIT_TIME, time, id);
	}

	@Override
	public void editRecipeImageName(long id, String imageName) {
		editRecipeString(SQL_EDIT_IMAGE_NAME, imageName, id);
	}

	@Override
	public void editRecipeFlagVisible(long id, boolean flagVisible) {
		editRecipeBoolean(SQL_EDIT_FLAG_VISIBLE, flagVisible, id);
	}

	@Override
	public void deleteRecipe(long id) {
		
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);
				ps.setLong(0, id);
				ps.executeUpdate();
				
				System.out.println("The recipe " + id + " is removed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}	
	}
	
	private void editRecipeString(String selector, String value, long recipeId) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(selector);
				ps.setString(1, value);
				ps.setLong(2, recipeId);
				ps.executeUpdate();
				
				System.out.println("DB update " + value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
	}
	
	private void editRecipeLong(String selector, long value, long recipeId) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(selector);
				ps.setLong(1, value);
				ps.setLong(2, recipeId);
				ps.executeUpdate();
				
				System.out.println("DB update " + value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
	}
	
	private void editRecipeBoolean(String selector, boolean value, long recipeId) {
		try {
			Class.forName(CLASS_NAME);
	
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS)) {
		
				PreparedStatement ps = con.prepareStatement(selector);
				ps.setBoolean(1, value);
				ps.setLong(2, recipeId);
				ps.executeUpdate();
				
				System.out.println("DB update " + value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
	}
}
