package br.edu.horus.javabasico2015;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	private Map<Integer, Item> itens;
	
	@Before
	public void init(){
		itens = new HashMap<>();
		Item abobora = new Item("abobora", 2.8d);
		itens.put(abobora.getId(), abobora);
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















