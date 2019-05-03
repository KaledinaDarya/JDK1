package by.http.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.entity.Recipe;
import by.http.web.pattern.SingletonCatalog;
import by.http.web.service.CatalogService;

public class ShowAllVisibleRecipesActionImpl implements BasicAction {

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog();
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		List<Recipe> recipes = catalogService.getCatalogVisibleRecipes();
		
		resp.getWriter().println(recipes.toString());
		System.out.println("show all visible recipes");
	}

}
