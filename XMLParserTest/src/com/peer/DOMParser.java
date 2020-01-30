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

	private NodeList getChildren(NodeList nodeList) {
		NodeList childNodeList = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node b = nodeList.item(i);
			if (b.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) b;
				System.out.println(element.getTagName() + "=" + element.getTextContent());
				childNodeList = element.getChildNodes();
				return childNodeList;
			} else {
				System.out.println("No more elements");
				System.out.println(b.getTextContent() + "=" + b.getTextContent());
			}
		}
		return childNodeList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("2027341478.xml");
			NodeList BillItemGroupList = doc.getElementsByTagName("BillItemsGroup");
			DOMParser domParser = new DOMParser();
			NodeList billItemGroupChildren = domParser.getChildren(BillItemGroupList);
			NodeList billItemGroupChildren2 = domParser.getChildren(billItemGroupChildren);
			

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
