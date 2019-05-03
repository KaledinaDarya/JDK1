package by.http.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;
import by.http.web.command.CommandManager;

@WebServlet("/MySecondServlet")
public class MySecondServlet extends HttpServlet{

	public MySecondServlet() {
		super();
		System.out.println("constructor");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		processRequesst(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		processRequesst(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("service");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init");
	}
	
	private void processRequesst(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		String action = req.getParameter("action");
		
		System.out.println("action: " + action);
		
		if (action != null) {
			
			BasicAction basicAction = CommandManager.definedAction(action);
			basicAction.perfomAction(req, resp);
		}
	}
}
