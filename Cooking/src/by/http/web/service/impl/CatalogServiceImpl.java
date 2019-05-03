package by.http.web.service.impl;

import java.util.List;

import by.http.web.dao.RecipeDao;
import by.http.web.dao.UserDao;
import by.http.web.entity.Recipe;
import by.http.web.entity.User;
import by.http.web.pattern.SingletonDaoSql;
import by.http.web.service.CatalogService;

public class CatalogServiceImpl implements CatalogService {
	
	private static SingletonDaoSql factory = SingletonDaoSql.getFactory();

	private static RecipeDao recipeDao = factory.getRecipeDao();
	private static UserDao userDao = factory.getUserDao();
	
	@Override
	public List<Recipe> getCatalogRecipes() {
		return recipeDao.readAll();
	}
	
	@Override
	public List<Recipe> getCatalogVisibleRecipes() {
		return recipeDao.readAllVisibleRecipes();
	}

	@Override
	public List<User> getCatalogUsers() {
		return userDao.readAll();
	}
	
	@Override
	public void addRecipeToCatalog(String recipe_title, String recipe_description, long recipe_complexity, 
			long recipe_time, String recipe_imageName, boolean recipe_flagVisible) {
		Recipe recipe = new Recipe(recipe_title, recipe_description, recipe_complexity, recipe_time, recipe_imageName, recipe_flagVisible);
		recipeDao.addRecipe(recipe);
		System.out.println(recipeDao.readAllVisibleRecipes());
	}

	@Override
	public Recipe findRecipeFromCatalogById(long recipe_id) {
		return recipeDao.findRecipeById(recipe_id);
	}
	
	@Override
	public List<Recipe> findRecipeFromCatalogByTitle(String recipe_title) {
		return recipeDao.findRecipeByTitle(recipe_title);
	}

	@Override
	public void editRecipeTitleFromCatalog(long recipe_id, String recipe_title) {
		recipeDao.editRecipeTitle(recipe_id, recipe_title);
	}

	@Override
	public void editRecipeDescriptionFromCatalog(long recipe_id, String recipe_description) {
		recipeDao.editRecipeDescription(recipe_id, recipe_description);
	}

	@Override
	public void editRecipeComplexityFromCatalog(long recipe_id, long recipe_complexity) {
		recipeDao.editRecipeComplexity(recipe_id, recipe_complexity);
	}

	@Override
	public void editRecipeTimeFromCatalog(long recipe_id, long recipe_time) {
		recipeDao.editRecipeTime(recipe_id, recipe_time);
	}

	@Override
	public void editRecipeImageNameFromCatalog(long recipe_id, String recipe_imageName) {
		recipeDao.editRecipeImageName(recipe_id, recipe_imageName);
	}

	@Override
	public void editRecipeFlagVisibleFromCatalog(long recipe_id, boolean recipe_flagVisible) {
		recipeDao.editRecipeFlagVisible(recipe_id, recipe_flagVisible);
	}

	@Override
	public void deleteRecipeFromCatalog(long recipe_id) {
		recipeDao.editRecipeFlagVisible(recipe_id, false);
		//recipeDao.deleteRecipe(recipe_id);
		System.out.println(recipeDao.readAllVisibleRecipes());
	}
}
