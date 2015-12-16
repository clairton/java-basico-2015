package br.edu.horus.javabasico2015;

import org.junit.Test;

public class CpfTest {

	@Test
	public void test() {
		new Cpf("000.000.000-00");
	}
	
	@Test(expected= RuntimeException.class)
	public void testIsInvalid() {
		new Cpf("000.000.00000");
	}

}
