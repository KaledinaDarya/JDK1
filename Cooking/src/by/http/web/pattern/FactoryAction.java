package by.http.web.pattern;

import by.http.web.command.impl.AddRecipeActionImpl;
import by.http.web.command.impl.DefaultActionImpl;
import by.http.web.command.impl.DeleteRecipeByIdActionImpl;
import by.http.web.command.impl.EditRecipeComplexityActionImpl;
import by.http.web.command.impl.EditRecipeDescriptionActionImpl;
import by.http.web.command.impl.EditRecipeFlagVisibleActonImpl;
import by.http.web.command.impl.EditRecipeImageNameActionImpl;
import by.http.web.command.impl.EditRecipeTimeActionImpl;
import by.http.web.command.impl.EditRecipeTitleActionImpl;
import by.http.web.command.impl.FindRecipeByTitleActionImpl;
import by.http.web.command.impl.ShowAllRecipesActionImpl;
import by.http.web.command.impl.ShowAllUsersActionImpl;
import by.http.web.command.impl.ShowAllVisibleRecipesActionImpl;
import by.http.web.command.impl.ShowRecipeActionImpl;

public class FactoryAction {

	private static FactoryAction _factory = null;
	
	private static ShowAllRecipesActionImpl _showAllRecipesActionImpl;
	private static ShowAllVisibleRecipesActionImpl _showAllVisibleRecipesActionImpl;
	private static ShowAllUsersActionImpl _showAllUsersActionImpl;
	private static ShowRecipeActionImpl _showRecipeActionImpl;
	private static AddRecipeActionImpl _addRecipeActionImpl;
	private static FindRecipeByTitleActionImpl _findRecipeByTitleActionImpl;
	private static EditRecipeTitleActionImpl _editRecipeTitleActionImpl;
	private static EditRecipeDescriptionActionImpl _editRecipeDescriptionActionImpl;
	private static EditRecipeComplexityActionImpl _editRecipeComplexityActionImpl;
	private static EditRecipeTimeActionImpl _editRecipeTimeActionImpl;
	private static EditRecipeImageNameActionImpl _editRecipeImageNameActionImpl;
	private static EditRecipeFlagVisibleActonImpl _editRecipeFlagVisibleActonImpl;
	private static DeleteRecipeByIdActionImpl _deleteRecipeByIdActionImpl;
	private static DefaultActionImpl _defaultActionImpl;
	
	private FactoryAction() {
		_showAllRecipesActionImpl = new ShowAllRecipesActionImpl();
		_showAllVisibleRecipesActionImpl = new ShowAllVisibleRecipesActionImpl();
		_showAllUsersActionImpl = new ShowAllUsersActionImpl();
		_showRecipeActionImpl = new ShowRecipeActionImpl();
		_addRecipeActionImpl = new AddRecipeActionImpl();
		_findRecipeByTitleActionImpl = new FindRecipeByTitleActionImpl();
		_editRecipeTitleActionImpl = new EditRecipeTitleActionImpl();
		_editRecipeDescriptionActionImpl = new EditRecipeDescriptionActionImpl();
		_editRecipeComplexityActionImpl = new EditRecipeComplexityActionImpl();
		_editRecipeTimeActionImpl = new EditRecipeTimeActionImpl();
		_editRecipeImageNameActionImpl = new EditRecipeImageNameActionImpl();
		_editRecipeFlagVisibleActonImpl = new EditRecipeFlagVisibleActonImpl();
		_deleteRecipeByIdActionImpl = new DeleteRecipeByIdActionImpl();
		_defaultActionImpl = new DefaultActionImpl();
	}

	public ShowAllRecipesActionImpl getShowAllRecipes() {
		return _showAllRecipesActionImpl;
	}
	
	public ShowAllVisibleRecipesActionImpl getShowAllVisibleRecipes() {
		return _showAllVisibleRecipesActionImpl;
	}
	
	public ShowAllUsersActionImpl getShowAllUsers() {
		return _showAllUsersActionImpl;
	}
	
	public ShowRecipeActionImpl getShowRecipe() {
		return _showRecipeActionImpl;
	}
	
	public AddRecipeActionImpl getAddRecipe() {
		return _addRecipeActionImpl;
	}

	public FindRecipeByTitleActionImpl getFindRecipeByTitle() {
		return _findRecipeByTitleActionImpl;
	}

	public EditRecipeTitleActionImpl getEditRecipeTitle() {
		return _editRecipeTitleActionImpl;
	}

	public EditRecipeDescriptionActionImpl getEditRecipeDescription() {
		return _editRecipeDescriptionActionImpl;
	}

	public EditRecipeComplexityActionImpl getEditRecipeComplexity() {
		return _editRecipeComplexityActionImpl;
	}

	public EditRecipeTimeActionImpl getEditRecipeTime() {
		return _editRecipeTimeActionImpl;
	}

	public EditRecipeImageNameActionImpl getEditRecipeImageName() {
		return _editRecipeImageNameActionImpl;
	}

	public EditRecipeFlagVisibleActonImpl getEditRecipeFlagVisible() {
		return _editRecipeFlagVisibleActonImpl;
	}
	
	public DeleteRecipeByIdActionImpl getDeleteRecipeById() {
		return _deleteRecipeByIdActionImpl;
	}

	public static FactoryAction getFactory() {
		if (_factory == null) {
			_factory = new FactoryAction();
		}
		return _factory;
	}
	
	public DefaultActionImpl getDefaultAction() {
		return _defaultActionImpl;
	}
}
