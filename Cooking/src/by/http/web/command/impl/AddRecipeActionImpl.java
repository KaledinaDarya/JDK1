package by.http.web.command.impl;

import static by.http.web.utils.WebConstant.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.pattern.SingletonCatalog;
import by.http.web.service.CatalogService;

public class AddRecipeActionImpl implements BasicAction {

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog();
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String recipeTitle = req.getParameter(REQ_PARAM_RECIPE_TITLE);
		String recipeDescription = req.getParameter(REQ_PARAM_RECIPE_DESCRIPTION) != null ? req.getParameter(REQ_PARAM_RECIPE_DESCRIPTION) : "";
		long recipeComplexity = req.getParameter(REQ_PARAM_RECIPE_COMPLEXITY) != null ? Integer.parseInt(req.getParameter(REQ_PARAM_RECIPE_COMPLEXITY)) : 1;
		long recipeTime = req.getParameter(REQ_PARAM_RECIPE_TIME) != null ? Integer.parseInt(req.getParameter(REQ_PARAM_RECIPE_TIME)) : 10;
		String recipeImageName = req.getParameter(REQ_PARAM_RECIPE_IMAGE_NAME) !=null ? req.getParameter(REQ_PARAM_RECIPE_IMAGE_NAME) : "default";
		boolean recipeFlagVisible = req.getParameter(REQ_PARAM_RECIPE_FLAG_VISIBLE) != null ? Boolean.parseBoolean(req.getParameter(REQ_PARAM_RECIPE_FLAG_VISIBLE)) : true;
		if (recipeTitle != null) {
			System.out.println("recipeTitle: " + recipeTitle);
			catalogService.addRecipeToCatalog(recipeTitle, recipeDescription, recipeComplexity, recipeTime, recipeImageName, recipeFlagVisible);
		}
	}

}
