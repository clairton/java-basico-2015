package br.edu.horus.javabasico2015;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class XStreamTest {

	@Test
	public void test(){
		XStream xstream = new XStream();
		Item item = new Item("Banana", 3.01d);	
		xstream.alias("item", Item.class);
		/*
		 * necessário chamar o metodo caso precise customizar o nome
		 * das tags com anotações
		 */
		//xstream.processAnnotations(Item.class);
		String xml = xstream.toXML(item);
		System.out.println(xml);
	}
	
}
