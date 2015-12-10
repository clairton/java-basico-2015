package br.edu.horus.lacos;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetTest {

	@Test
	public void testNaoAceitaDuplicados(){
		//usamos o Set pois o List aceita items duplicados
		Set<String> nomes = new HashSet<>();
		nomes.add("João");
		assertEquals(1, nomes.size());
		nomes.add("João");
		assertEquals(1, nomes.size());
	}
	
	@Test
	public void testNaoAceitaItemsDuplicados(){
		Set<Item> itens = new HashSet<Item>();
		itens.add(new Item("Melancia", 4.00d));
		assertEquals(1, itens.size());
		itens.add(new Item("melancia", 4.00d));
		assertEquals(1, itens.size());
	}
	
}
