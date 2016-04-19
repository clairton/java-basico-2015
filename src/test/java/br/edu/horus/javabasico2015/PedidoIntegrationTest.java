package br.edu.horus.javabasico2015;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(CdiTestRunner.class)
public class PedidoIntegrationTest {

	@ClassRule
	public static TestRule rule = new LiquibaseRule();
	
	@Inject
	private EntityManager manager;
	
	
	@Test
	public void test() {
		Pessoa pessoa = new PessoaFisica("bernadete", LocalDate.now());
		Cliente cliente = new Cliente(pessoa);
		Pedido pedido = new Pedido(cliente);
		Item item = new Item("banana de pijama", 1.0);
		pedido.adicionar(item);
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.persist(pedido);
		manager.getTransaction().commit();
	}

}
