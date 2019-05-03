package by.http.web.command;

import by.http.web.patterns.FactoryAction;

public class CommandManager{
	
	private static FactoryAction factory = FactoryAction.getFactory();
	
	public static BasicAction definedAction(String action) {
		
		switch (action) {
		case "1":
			return factory.getOneAction();
		case "2":
			return factory.getTwoAction();
		case "add_author":
			return factory.getAddAuthorAction();
		case "add_book":
			return factory.getAddBookAction();
		case "delete_book_by_id":
			return factory.getDeleteBookAction();
		case "edit_book_title_by_id":
			return factory.getEditBookByIdAction();
		case "find_book_by_title":
			return factory.getFindBookByTitleAction();
		default:
			return factory.getDefaultAction();
		}		
	}
}
