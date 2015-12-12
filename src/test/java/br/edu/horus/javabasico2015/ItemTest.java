package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		Item item = new Item("Pão", 1.01);
		System.out.println(item.getNome());
	}
	
	@Test
	public void testIsEquals(){
		Identificavel uva = new Item("Uva", 3.02d);
		Identificavel morango = new Item("Morango", 3.02d);
		assertFalse(uva.equals(morango));
	}
}
