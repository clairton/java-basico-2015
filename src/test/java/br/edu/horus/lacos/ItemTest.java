package br.edu.horus.lacos;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		Item item = new Item("Pão", 1.01);
		System.out.println(item.getNome());
	}

}
