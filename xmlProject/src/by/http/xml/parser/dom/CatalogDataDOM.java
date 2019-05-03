package by.http.xml.parser.dom;

import java.awt.geom.CubicCurve2D;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CatalogDataDOM {
	
	private static final String XML_FILE_PATH = "resources/family.xml";
	
	public static void main(String[] args) {
		CatalogDataDOM catalogDataDOM = new CatalogDataDOM();
		catalogDataDOM.readStationEquip();
	}
	
	public void readStationEquip() {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(XML_FILE_PATH);
			
			parseDocumentSecond(document);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	/*private void parseDocument(Document document) {
		
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		NodeList elements = root.getChildNodes();
		
		for (int i = 0; i < elements.getLength(); i++) {
			elements.item(i).getNodeName();
			System.out.println("name(i): " + elements.item(i).getNodeName());
			
			if (elements.item(i).getNodeType() == 1) {
			
				Element current = (Element)elements.item(i);
				NodeList childrenElements = current.getChildNodes();
				
				for (int j = 0; j < childrenElements.getLength(); j++) {
					childrenElements.item(j).getNodeName();
					if (childrenElements.item(j).getNodeType() == 1) {
					System.out.println("--- name(j): " + childrenElements.item(j).getNodeName());	
					}
				}
			}
		}
	}*/
	
	private static void parseDocumentSecond(Document document) {
		
		Element root = document.getDocumentElement();
		NodeList node = root.getElementsByTagName("family");
		
		for (int i = 0; i < node.getLength(); i++) {
			
			Element currentNode = (Element)node.item(i);
			
			String name = currentNode.getNodeName();
			System.out.println(name);
			
			String adress = currentNode.getAttribute("adress");
			System.out.println(adress);
			
			System.out.println(node.item(i).getChildNodes());
			
			NodeList entity = currentNode.getChildNodes();
			for (int j = 0; j < entity.getLength(); j++) {
				if (entity.item(j).getNodeType() == 1) {
					String entityName = entity.item(j).getNodeName();
					System.out.println(entityName);
				}
			}
			
			Element mother = getSingleChild(currentNode, "mother");
			System.out.println(mother.getNodeName() + ":");
			
			getAllChildFieldsWithData(mother);
		}
	}	
	
	private static Element getSingleChild(Element element, String childName) {
		
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
	
	private static void getAllChildFieldsWithData(Element element) {
		
		NodeList fields = element.getChildNodes();
		for (int i = 0; i < fields.getLength(); i++) { 
			if (fields.item(i).getNodeType() == 1) {
				String field = fields.item(i).getNodeName();
				System.out.print("--- " + field);
				String text = fields.item(i).getTextContent().trim();
				System.out.println(" - " + text);
			}
		}
	}
}
