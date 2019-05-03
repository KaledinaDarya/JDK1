package by.http.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.entity.Book;
import by.http.web.patterns.SingletonCatalog;
import by.http.web.service.CatalogService;

public class TwoActionImpl implements BasicAction{

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog(); 
	private CatalogService catalogService = singletonCatalog.getCatalogService();
	
	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		List<Book> books = catalogService.getCatalogBooks();
		
		resp.getWriter().println(books);
		
		System.out.println("two perf");
	}
}
