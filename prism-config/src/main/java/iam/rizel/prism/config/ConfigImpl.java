package iam.rizel.prism.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigImpl implements Config {

	private Document doc;
	private XPath xPath;
	
	public ConfigImpl(Class initClass) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			File file = new File("config/" + initClass.getSimpleName() + ".xml");
			
			if(file.exists())
				doc = builder.parse(file);
			else
				doc = builder.parse(initClass.getResourceAsStream("/config.xml"));
			
			XPathFactory xPathFactory = XPathFactory.newInstance();
			xPath = xPathFactory.newXPath();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getString(String path) {
		try {
			XPathExpression exp = xPath.compile(path);
			
			Node r = (Node) exp.evaluate(doc, XPathConstants.NODE);
			return r.getTextContent();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			System.out.println("Config get error!");
			return null;
		}
	}
}
