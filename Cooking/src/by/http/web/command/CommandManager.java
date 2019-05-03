package by.http.web.command;

import by.http.web.pattern.FactoryAction;

public class CommandManager {
	
	private static FactoryAction factory = FactoryAction.getFactory();
	
	public static BasicAction definedAction(String action) {
		
		switch (action) {
		case "show_all_recipes":
			return factory.getShowAllRecipes();
		case "show_all_visible_recipes":
			return factory.getShowAllVisibleRecipes();
		case "show_all_users":
			return factory.getShowAllUsers();
		case "show_recipe":
			return factory.getShowRecipe();
		case "add_recipe":
			return factory.getAddRecipe();
		case "find_recipe_by_title":
			return factory.getFindRecipeByTitle();
		case "edit_recipe_title":
			return factory.getEditRecipeTitle();
		case "edit_recipe_description":
			return factory.getEditRecipeDescription();
		case "edit_recipe_complexity":
			return factory.getEditRecipeComplexity();
		case "edit_recipe_time":
			return factory.getEditRecipeTime();
		case "edit_recipe_image_name":
			return factory.getEditRecipeImageName();
		case "edit_recipe_flag_visible":
			return factory.getEditRecipeFlagVisible();
		case "delete_recipe":
			return factory.getDeleteRecipeById();
		default:
			return factory.getDefaultAction();
		}
	}

}
