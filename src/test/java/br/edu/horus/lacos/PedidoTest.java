package br.edu.horus.lacos;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PedidoTest {

	@Test
	public void testAdicionarItem() {
		Pedido pedido = new Pedido();
		Item item = new Item("Laranja", 0.50);
		pedido.adicionar(item);
		assertEquals(1, pedido.getItems().size());
	}

}
