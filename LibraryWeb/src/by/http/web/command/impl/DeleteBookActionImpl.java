package by.http.web.command.impl;

import static by.http.web.utils.WebConstant.REQ_PARAM_BOOK_ID;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.patterns.SingletonCatalog;
import by.http.web.service.CatalogService;

public class DeleteBookActionImpl implements BasicAction {

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog(); 
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		long bookId = Integer.parseInt(req.getParameter(REQ_PARAM_BOOK_ID));		
		
		if (bookId >= 0) {
			System.out.println("bookId: " + bookId);
			if (catalogService.findBookFromCatalog(bookId) != null) {
				catalogService.deleteBookFromCatalog(bookId);		
			} else {
				System.out.println("There is no book with such id.");
			}
		}
	}
}
