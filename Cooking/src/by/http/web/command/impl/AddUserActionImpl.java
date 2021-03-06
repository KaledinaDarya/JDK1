package by.http.web.command.impl;

import static by.http.web.utils.WebConstant.REQ_PARAM_USER_RIGHT;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.pattern.SingletonCatalog;
import by.http.web.service.CatalogService;

public class AddUserActionImpl implements BasicAction {

	private SingletonCatalog singletonCatalog = SingletonCatalog.getSingletonCatalog();
	private CatalogService catalogService = singletonCatalog.getCatalogService();

	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String right = req.getParameter(REQ_PARAM_USER_RIGHT);
		if (right != null) {
			System.out.println("right: " + right);
			//TODO
			//catalogService.addUserToCatalog(right);
		}
	}

}
