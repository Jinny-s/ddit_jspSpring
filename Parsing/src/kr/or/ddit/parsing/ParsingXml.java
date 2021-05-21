package kr.or.ddit.parsing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParsingXml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException { 
        
		try {
        	
            File file = new File("application-context.xml");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            
            document.getDocumentElement().normalize();
            
            NodeList beanList = document.getElementsByTagName("bean");
            
            for (int i = 0; i < beanList.getLength(); i++) {
            	Node beans = beanList.item(i);
                if (beans.getNodeType() == Node.ELEMENT_NODE) {
                    Element bean = (Element) beans;
                    System.out.println("id : " + bean.getAttribute("id") + " / class : " + bean.getAttribute("class"));
                    NodeList propertyList = bean.getElementsByTagName("property");
                    
                    for(int j = 0; j < propertyList.getLength(); j++) {
                    	Element property = (Element) propertyList.item(j);
                    	System.out.println("name : " + property.getAttribute("name") + " / ref-value : " + property.getAttribute("ref-value"));
                    }
                }
            }
        }
        catch(IOException e) {
        	e.printStackTrace();
        } 
    }
	
}
