package br.edu.horus.javabasico2015;

import org.junit.Test;

import br.edu.horus.javabasico2015.Item;

public class ItemTest {

	@Test
	public void test() {
		Item item = new Item("Pão", 1.01);
		System.out.println(item.getNome());
	}

}
