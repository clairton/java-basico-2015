package br.edu.horus.javabasico2015;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiTestRunner.class)
public class ServicoDaoTest {

	@Inject
	private ServicoDao servico;
	
	@Test
	public void testSalvar() {
		Item item = new Item("Computador Potente", 2000.01);
		servico.salvar(item);
	}

}
