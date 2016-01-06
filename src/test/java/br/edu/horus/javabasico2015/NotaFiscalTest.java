package br.edu.horus.javabasico2015;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class NotaFiscalTest {

	@Test
	public void test() {
		NotaFiscal p1 = new NotaFiscal("1", new Cliente(new PessoaFisica("Pedro", LocalDate.now())));
		NotaFiscal p2 = new NotaFiscal("1", new Cliente(new PessoaFisica("João", LocalDate.now())));
		assertFalse(p1.equals(p2));
	}

}
