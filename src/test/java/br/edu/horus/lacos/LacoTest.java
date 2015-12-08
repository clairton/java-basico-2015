package br.edu.horus.lacos;

import org.junit.Test;

public class LacoTest {
	String[] nomes = { "Hello Word!", "João", "Pedro", "Juca" };

	@Test
	public void testWhile() {

		int i = 0;

		while (i < nomes.length) {
			System.out.println(nomes[i]);
			i++;
		}
	}

	@Test
	public void testForeach() {
		for (String nome : nomes) {
			System.out.println(nome);
		}
	}

	@Test
	public void testFor() {
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);

			// exemplo de expressão ternaria
			boolean ultima = i == nomes.length - 1 ? true : false;

			// if else sem expressão ternaria
			if (i == nomes.length - 1) {
				ultima = true;
			} else {
				ultima = false;
			}

			if (ultima) {
				System.err.println("Esta na ultima iteração");
			} else {
				System.out.println("Ainda tem muita coisa para executar");
			}
		}

	}
}
