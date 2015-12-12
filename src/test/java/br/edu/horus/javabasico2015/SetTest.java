package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.edu.horus.javabasico2015.Item;

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
