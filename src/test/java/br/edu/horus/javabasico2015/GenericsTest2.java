package br.edu.horus.javabasico2015;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

public class GenericsTest2 {


	@Test
	public void test(){
		Pessoa pessoa = new PessoaFisica("Anastacio", LocalDate.of(1990, 1, 1));
		
		Cliente cliente = new Cliente(pessoa, new BigDecimal(20.01));
		
		Pedido notaFiscal = new Pedido(cliente);
		
		Item banana = new Item("banana", 4.6d);
		
		notaFiscal.adicionar(banana);
		
		Notificacao email = new Email();
		
		email.enviar(notaFiscal);
	}
	
}
