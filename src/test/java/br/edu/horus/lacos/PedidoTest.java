package br.edu.horus.lacos;


import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {
	private Pedido pedido = new Pedido();	
	
	@Before
	public void inicio(){
		pedido.limpar();		
		Item abacaxi = new Item("Abacaxi", 2.04);
		Item jabuticaba = new Item("Jabuticaba", 3.19);
		pedido.adicionar(abacaxi, jabuticaba);
	}

	@Test
	public void testAdicionarItem() {
		Item item = new Item("Laranja", 0.50);
		pedido.adicionar(item);
		assertEquals(Integer.valueOf(3), pedido.contar());
	}
	
	@Test
	public void testRemoverItem(){
		Item item = new Item("Bergamota", 0.80);
		pedido.adicionar(item);
		pedido.remover(item);
		assertEquals(Integer.valueOf(2), pedido.contar());
	}	
	
	@Test
	public void testTotalizar(){
		assertEquals(Double.valueOf(5.23), pedido.totalizar());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testNaoPodeAdicionarDiretamente(){
		pedido.getItems().add(new Item("Batata", 2.09d));
	}
	
	@Test
	public void testItemPorNome(){
		String nome = "Abacate";
		Item abacaxi = new Item(nome, 2.04);
		pedido.adicionar(abacaxi);
		Collection<Item> items = pedido.itemsPorNome();
		assertEquals(nome, items.iterator().next().getNome());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
