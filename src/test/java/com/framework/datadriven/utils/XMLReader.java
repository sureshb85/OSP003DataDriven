package com.framework.datadriven.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	private static final String COMPANYXMLFILE = System.getProperty("user.dir") + "\\testdata\\company.xml";

	public static void main(String[] args) throws Exception {
		Node node = readXMLFile(COMPANYXMLFILE, "staff", 1);
		Element element = (Element) node;

		String id = element.getAttribute("id");

		String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
		String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
		String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();

		NodeList salaryNodeList = element.getElementsByTagName("salary");
		String salary = salaryNodeList.item(0).getTextContent();

		String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

		System.out.println("Current Element :" + node.getNodeName());
		System.out.println("Staff Id : " + id);
		System.out.println("First Name : " + firstname);
		System.out.println("Last Name : " + lastname);
		System.out.println("Nick Name : " + nickname);
		System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);
	}

	static Node readXMLFile(String COMPANYXMLFILE, String tagName, int childNo) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;

		builder = factory.newDocumentBuilder();
		document = builder.parse(new File(COMPANYXMLFILE));

		document.getDocumentElement().normalize();

		Element root = document.getDocumentElement();
		System.out.println("root: " + root.getNodeName());

		NodeList list = document.getElementsByTagName(tagName);

		Node node = list.item(1);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			return node;
		} else {
			return null;
		}
	}
}