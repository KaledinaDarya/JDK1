package by.http.xml.parser.sax;

import static utils.StringConstant.*;

import by.http.xml.parser.sax.entity.BaseEntity;
import by.http.xml.parser.sax.entity.Child;
import by.http.xml.parser.sax.entity.Father;
import by.http.xml.parser.sax.entity.Mother;

public class FamilyFactory {

	private static FamilyFactory _factory = null;
	private static Mother mother;
	private static Father father;
	private static Child child;
		
	public BaseEntity getEntity(String tag) {
		BaseEntity entity = null;
		
		switch(tag){
		case MOTHER:
			entity = mother;
			break;
		case FATHER: 
			entity = father;
			break;
		case CHILD:
			entity = child;
		}
		return entity;
	}
	
	private FamilyFactory() {
		super();
		mother = new Mother();
		father = new Father();
		child = new Child();
	}
	
	public static FamilyFactory getFamilyFactory() {
		if (_factory == null) {
			_factory = new FamilyFactory();
		}
		return _factory;
	}

	public static void setMother(Mother mother) {
		FamilyFactory.mother = mother;
	}

	public static Mother getMother() {
		return mother;
	}
}
