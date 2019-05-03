package by.http.web.command.impl;

import static by.http.web.utils.WebConstant.REQ_PARAM_BOOK_TITLE;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.patterns.SingletonCatalog;
import by.http.web.service.CatalogService;

public class AddBookActionImpl implements BasicAction{

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog(); 
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String bookTitle = req.getParameter(REQ_PARAM_BOOK_TITLE);		
		
		if (bookTitle != null) {
			System.out.println("bookTitle: " + bookTitle);
			catalogService.addBookToCatalog(bookTitle);	
		}
	}
}
