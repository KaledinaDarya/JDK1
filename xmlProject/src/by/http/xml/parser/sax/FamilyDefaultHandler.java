package by.http.xml.parser.sax;

import static utils.StringConstant.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.http.xml.parser.sax.entity.Family;
import by.http.xml.parser.sax.entity.BaseEntity;
import by.http.xml.parser.sax.entity.Child;
import by.http.xml.parser.sax.entity.Father;
import by.http.xml.parser.sax.entity.Mother;

public class FamilyDefaultHandler extends DefaultHandler{
	
	private FamilyFactory familyFactory = FamilyFactory.getFamilyFactory();
	
	private Family family;
	private Mother mother;
	private Father father;
	private Child child;
	
	private BaseEntity entity;
	
	private String textValue;

	public void startDocument() throws SAXException {
		System.out.println("start");
	}
	
	public Family getFamily() {
		return family;
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		textValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String url, String localName, String qName)
			throws SAXException {
		
		switch(qName) {
		case FAMILY:
			break;
		case MOTHER:
			family.setMother(entity); 
			break;
		case FATHER:
			family.setFather(entity);
			break;
		case CHILD: 
			family.setChild(entity);
			break;
		case SURNAME:
			entity.setSurName(textValue);
			break;
		case NAME:
			entity.setName(textValue);
			break;
		case MAIDEN_NAME:
			mother = FamilyFactory.getMother();
			mother.setMaidenName(textValue);	
			FamilyFactory.setMother(mother);
			break;
		case AGE:
			entity.setAge(textValue);
			break;
		case GENDER:
			entity.setGender(textValue);
			break;
		}
	}

	@Override
	public void startElement(String url, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		switch(qName) {
			case FAMILY:
				family = new Family();
				family.setAdress(attributes.getValue(ADRESS));
				break;
			case MOTHER:
				mother = new Mother();
				entity = familyFactory.getEntity(qName);
				break;
			case FATHER:
				father = new Father();
				entity = familyFactory.getEntity(qName);
				break;
			case CHILD:
				child = new Child();
				entity = familyFactory.getEntity(qName);
		}
	}
}
