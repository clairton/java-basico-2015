package br.edu.horus.javabasico2015;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdutoTest {

	@Test
	public void test() {
		Produto p1 = new Produto("1", "berinjela", 56.4d);
		Produto p2 = new Produto("1", "pessego", 56.4d);
		assertFalse(p1.equals(p2));
	}

}
