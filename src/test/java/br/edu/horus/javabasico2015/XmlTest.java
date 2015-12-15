package br.edu.horus.javabasico2015;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
