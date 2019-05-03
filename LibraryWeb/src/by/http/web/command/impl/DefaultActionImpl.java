package by.http.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.web.command.BasicAction;

public class DefaultActionImpl implements BasicAction{

	@Override
	public void perfomAction(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("default perf");
	}
}
