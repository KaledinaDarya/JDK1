package by.http.web.command.impl;

import static by.http.web.utils.WebConstant.REQ_PARAM_RECIPE_ID;
import static by.http.web.utils.WebConstant.REQ_PARAM_RECIPE_COMPLEXITY;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.pattern.SingletonCatalog;
import by.http.web.service.CatalogService;

public class EditRecipeComplexityActionImpl implements BasicAction {

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog();
	private CatalogService catalogService = singletonCatalog.getCatalogService();

	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		long recipeId = Integer.parseInt(req.getParameter(REQ_PARAM_RECIPE_ID));
		long recipeComplexity = Integer.parseInt(req.getParameter(REQ_PARAM_RECIPE_COMPLEXITY));
		
		if (recipeId >= 0) {
			System.out.println("recipeId: " + recipeId);
			if (catalogService.findRecipeFromCatalogById(recipeId) != null) {
				catalogService.editRecipeComplexityFromCatalog(recipeId, recipeComplexity);	
			} else {
				System.out.println("There is no recipe with such id for editing.");
			}
		}
		
	}

}
