package by.http.xml.parser.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class FamilySAXParser {
	
	private static FamilyDefaultHandler hdltr = new FamilyDefaultHandler();
	
	public static void main(String[] args) {
		try{
			parseFamilyXML();
		} catch (FamilyParserExseption e){
			e.printStackTrace();
		}
	}
	
	public static void parseFamilyXML() throws FamilyParserExseption {
		
		try{
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			SAXParser parser = parserFactory.newSAXParser();
			
			parser.parse("resources/family.xml", hdltr);
			
			System.out.println(hdltr.getFamily());
			
		} catch (SAXException | ParserConfigurationException |  IOException e) {
			throw new FamilyParserExseption("some proplem during SAX parsing", e);
		}
		
	}
}
