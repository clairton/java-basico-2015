package br.edu.horus.javabasico2015;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class PedidoIntegrationTest {

	@ClassRule
	public static TestRule rule = new LiquibaseRule();
	
	private static EntityManager manager = Persistence.createEntityManagerFactory("default")
															.createEntityManager();
	
	
	@Test
	public void test() {
		Pedido pedido = new Pedido();
		Item item = new Item("banana", 1.0);
		pedido.adicionar(item);
		manager.getTransaction().begin();
		manager.persist(pedido);
		manager.getTransaction().commit();
	}

}
