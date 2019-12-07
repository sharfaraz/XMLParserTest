package com.peer;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



public class DOMParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("2027341478.xml");
			NodeList BillItemGroupList = doc.getElementsByTagName("BillItemsGroup");
			for ( int i = 0; i< BillItemGroupList.getLength(); i++){
				Node b = BillItemGroupList.item(i);
				if (b.getNodeType() == Node.ELEMENT_NODE) {
					Element billItemGroup = (Element) b;
					NodeList billItemGroupChildren = billItemGroup.getChildNodes();
					for ( int j = 0; j<billItemGroupChildren.getLength(); j++) {
						Node c = billItemGroupChildren.item(j);
						if ( c.getNodeType() == Node.ELEMENT_NODE ) {
							Element name = (Element) c;
							if( name.hasChildNodes()) {
								System.out.println("has a child node");
								System.out.println(name.getTagName() + "=" + name.getTextContent());
							} else {
								System.out.println(name.getTagName() + "=" + name.getTextContent());
							}
						}
					}
				}
			}
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();			
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
