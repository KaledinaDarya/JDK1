package by.http.web.dao;

import java.util.List;

import by.http.web.entity.Recipe;

public interface RecipeDao {

	List<Recipe> readAll();
	List<Recipe> readAllVisibleRecipes();
	void addRecipe(Recipe recipe);
	List<Recipe> findRecipeByTitle(String title);
	Recipe findRecipeById(long id);
	void editRecipeTitle(long id, String title);
	void editRecipeDescription(long id, String description);
	void editRecipeComplexity(long id, long complexity);
	void editRecipeTime(long id, long time);
	void editRecipeImageName(long id, String imageName);
	void editRecipeFlagVisible(long id, boolean flagVisible);
	void deleteRecipe(long id);
}
