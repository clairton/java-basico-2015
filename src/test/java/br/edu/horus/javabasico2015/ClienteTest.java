package br.edu.horus.javabasico2015;

import java.time.LocalDate;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void test() {
		Pessoa pessoa = new PessoaFisica("Mercado Bom", LocalDate.of(2015, 1, 1));
		Cliente mercadoBom = new Cliente(pessoa);
		
		PessoaFisica pessoaFisica = mercadoBom.getPessoa();
		
		pessoaFisica.getNascidoEm();
		pessoaFisica.getNome();
	}

}
