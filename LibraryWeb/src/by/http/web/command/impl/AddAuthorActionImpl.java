package by.http.web.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.patterns.SingletonCatalog;
import by.http.web.service.CatalogService;

import static by.http.web.utils.WebConstant.*;

public class AddAuthorActionImpl implements BasicAction{

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog(); 
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String authorName = req.getParameter(REQ_PARAM_AUTHOR_NAME);		
		
		if (authorName != null) {
			System.out.println("authorName: " + authorName);
			catalogService.addAuthorToCatalog(authorName);	
		}
	}
}
