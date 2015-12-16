package br.edu.horus.javabasico2015;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlTest {

	@Test
	public void testLer() throws Exception{
		DocumentBuilderFactory factory 
			= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		String nome = "src/test/resources/itens.xml";
		Document document = builder.parse(new File(nome));
		NodeList nodes = document.getDocumentElement()
									.getChildNodes();
		
		List<Item> itens = new ArrayList<>();
		
		for(int i = 0; i < nodes.getLength(); i++){
			Node node = nodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) node;
				
				String id = element.getAttributes()
							.getNamedItem("id")
								.getNodeValue();
				
				String nomeItem = element.getElementsByTagName("nome")
									.item(0)
									.getChildNodes()
									.item(0)
									.getNodeValue();
				

				String valor = element.getElementsByTagName("valor")
									.item(0)
									.getChildNodes()
									.item(0)
									.getNodeValue();
				
				Item item = new Item(nomeItem, Double.valueOf(valor));
				item.setId(Integer.valueOf(id));
				
				itens.add(item);
			}			
		}
		
		for (Item item : itens) {
			System.err.println(item.getNome());
		}
	}
	
	
	
	
	
	
	@Test
	public void testEscrever() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.newDocument();
		Element itens = doc.createElement("itens");
		doc.appendChild(itens);
		
		Element item = doc.createElement("item");
		Attr id = doc.createAttribute("id");
		id.setValue("1");
		item.setAttributeNode(id);
		itens.appendChild(item);
		
		Element nome = doc.createElement("nome");
		nome.appendChild(doc.createTextNode("Jaspion"));
		item.appendChild(nome);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer =  transformerFactory.newTransformer();
		DOMSource source = new DOMSource(itens);
		
		StreamResult result = new StreamResult("target/itens.xml");
		transformer.transform(source, result);
	}
	
	@Test
	public void testXpath() throws Exception{
		DocumentBuilderFactory factory 
			= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		String nome = "src/test/resources/itens.xml";
		Document document = builder.parse(new File(nome));
		
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("/items/item[@id='1']/nome/text()");
		System.err.println((String) expr.evaluate(document, XPathConstants.STRING));
	}	
}
