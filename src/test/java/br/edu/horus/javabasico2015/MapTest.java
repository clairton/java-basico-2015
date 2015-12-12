package br.edu.horus.javabasico2015;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	private MapItem itens;
	private Integer id;//armaena o id gerado para abobora
	
	@Before
	public void init(){
		itens = new MapItem();
		Item abobora = new Item("abobora", 2.8d);
		//setamo o id gerado para abobora
		id = abobora.getId();
		itens.put(abobora.getId(), abobora);
	}
	
	@Test
	public void testRecuperar(){
		//recuperar o abobora
		itens.get(id);
	}
	
	@Test
	public void testAdicionar(){
		Item banana = new Item("Banana", 3.0d);
		itens.put(banana.getId(), banana);
	}
	
	@Test
	public void testRemover(){
		itens.remove(1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}















