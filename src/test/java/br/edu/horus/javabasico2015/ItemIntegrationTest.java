package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(CdiTestRunner.class)
public class ItemIntegrationTest {	
	@Inject
	private EntityManager manager;
	
	@ClassRule
	public static TestRule rule = new LiquibaseRule();


	@Test
	public void test() {
		/*
		 * exemplo para persistir um objeto
		 */
		Item item = new Item("havaianas todo mundo usa", 3.0);
		manager.getTransaction().begin();
		manager.persist(item);
		manager.getTransaction().commit();
		assertNotNull(manager.find(Item.class, item.getId()));
	}

	@Test
	public void testConsulta() {
		/*
		 * exemplo usando JPQL(Java Persisten Query Language)
		 */
		String consulta = "select item from Item item where item.nome like :nome";
		TypedQuery<Item> query = manager.createQuery(consulta, Item.class);
		query.setParameter("nome", "%a");
		query.getResultList();
	}
}
