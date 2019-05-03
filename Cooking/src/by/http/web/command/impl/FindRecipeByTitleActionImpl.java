package by.http.web.command.impl;

import static by.http.web.utils.WebConstant.REQ_PARAM_RECIPE_TITLE;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.pattern.SingletonCatalog;
import by.http.web.service.CatalogService;

public class FindRecipeByTitleActionImpl implements BasicAction {

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog();
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String recipeTitle = req.getParameter(REQ_PARAM_RECIPE_TITLE);
		
		if (recipeTitle != null) {
			System.out.println("recipeTitle: " + recipeTitle);
			catalogService.findRecipeFromCatalogByTitle(recipeTitle);	
		}
	}
}
