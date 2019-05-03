package by.http.web.service;

import java.util.List;

import by.http.web.entity.Recipe;
import by.http.web.entity.User;

public interface CatalogService {

	List<Recipe> getCatalogRecipes();
	List<Recipe> getCatalogVisibleRecipes();
	List<User> getCatalogUsers();
	
	void addRecipeToCatalog(String recipe_title, String recipe_description, long recipe_complexity, 
			long recipe_time, String recipe_imageName, boolean recipe_flagVisible);
	
	Recipe findRecipeFromCatalogById(long recipe_id);
	List<Recipe> findRecipeFromCatalogByTitle(String recipe_title);
	
	void editRecipeTitleFromCatalog(long recipe_id, String recipe_title);
	void editRecipeDescriptionFromCatalog(long recipe_id, String recipe_description);
	void editRecipeComplexityFromCatalog(long recipe_id, long recipe_complexity);
	void editRecipeTimeFromCatalog(long recipe_id, long recipe_time);
	void editRecipeImageNameFromCatalog(long recipe_id, String recipe_imageName);
	void editRecipeFlagVisibleFromCatalog(long recipe_id, boolean recipe_flagVisible);
	
	void deleteRecipeFromCatalog(long recipe_id);	
}
