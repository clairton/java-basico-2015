package br.edu.horus.lacos;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PedidoTest {

	@Test
	public void testAdicionarItem() {
		Pedido pedido = new Pedido();
		Item item = new Item("Laranja", 0.50);
		pedido.adicionar(item);
		assertEquals(Integer.valueOf(1), pedido.contar());
	}
	
	@Test
	public void testRemoverItem(){
		Pedido pedido = new Pedido();
		Item item = new Item("Bergamota", 0.80);
		pedido.adicionar(item);
		pedido.remover(item);
		assertEquals(Integer.valueOf(0), pedido.contar());
	}

}
