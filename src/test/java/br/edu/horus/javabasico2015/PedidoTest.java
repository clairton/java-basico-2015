package br.edu.horus.javabasico2015;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
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
	
	@Test
	public void testTotalizarComDesconto(){
		Pessoa pessoa = new PessoaFisica("Pedro", LocalDate.of(1, 1, 1));
		BigDecimal desconto = new BigDecimal("9.98");
		Cliente cliente = new Cliente(pessoa, desconto);
		Pedido pedido = new Pedido(cliente);
		pedido.adicionar(new Item("", 66.66d));
		assertEquals(Double.valueOf(60.01), pedido.totalizar());
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
	
	@Test
	public void testItemPesquisaPorNome(){
		String nome = "Pera";
		Item abacaxi = new Item(nome, 2.04);
		pedido.adicionar(abacaxi);
		try {
			pedido.pesquisarPorNome(nome);
		} catch (ItemNaoExisteException e) {
			e.getMessage();//retorna o "Item com o nome "" não encontrado"
			//fazer algo porque o item com o nome pesquisa não existe
		}
	}
	
	
	@Test(expected = ItemNaoExisteException.class)
	public void testItemPesquisaPorNomeInexistente() throws ItemNaoExisteException{
		pedido.pesquisarPorNome("xpto");
	}
}
