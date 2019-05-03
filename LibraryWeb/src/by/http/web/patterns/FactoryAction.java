package by.http.web.patterns;

import by.http.web.command.impl.AddAuthorActionImpl;
import by.http.web.command.impl.AddBookActionImpl;
import by.http.web.command.impl.DefaultActionImpl;
import by.http.web.command.impl.DeleteBookActionImpl;
import by.http.web.command.impl.EditBookByIdActionImpl;
import by.http.web.command.impl.FindBookByTitleActionImpl;
import by.http.web.command.impl.OneActionImpl;
import by.http.web.command.impl.TwoActionImpl;

public class FactoryAction {

	private static FactoryAction _factory = null;
	
	private static OneActionImpl _oneAction;
	private static TwoActionImpl _twoAction;
	
	private static AddAuthorActionImpl _addAuthorAction;
	private static AddBookActionImpl _addBookAction;
	private static DeleteBookActionImpl _deleteBookAction;
	private static EditBookByIdActionImpl _editBookByIdAction;
	private static FindBookByTitleActionImpl _findBookByTitleAction;
	private static DefaultActionImpl _defaultAction;
	
	private FactoryAction() {
		_oneAction = new OneActionImpl();
		_twoAction = new TwoActionImpl();
		
		_addAuthorAction = new AddAuthorActionImpl();
		_addBookAction = new AddBookActionImpl();
		_deleteBookAction = new DeleteBookActionImpl();
		_editBookByIdAction = new EditBookByIdActionImpl();
		_findBookByTitleAction = new FindBookByTitleActionImpl();
		_defaultAction = new DefaultActionImpl();
	}
	
	public OneActionImpl getOneAction() {
		return _oneAction;
	}

	public TwoActionImpl getTwoAction() {
		return _twoAction;
	}

	public AddAuthorActionImpl getAddAuthorAction() {
		return _addAuthorAction;
	}

	public AddBookActionImpl getAddBookAction() {
		return _addBookAction;
	}

	public DeleteBookActionImpl getDeleteBookAction() {
		return _deleteBookAction;
	}

	public EditBookByIdActionImpl getEditBookByIdAction() {
		return _editBookByIdAction;
	}

	public FindBookByTitleActionImpl getFindBookByTitleAction() {
		return _findBookByTitleAction;
	}

	public DefaultActionImpl getDefaultAction() {
		return _defaultAction;
	}

	public static FactoryAction getFactory() {
		if (_factory == null) {
			_factory = new FactoryAction();
		}
		return _factory;
	}

}
