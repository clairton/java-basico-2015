package br.edu.horus.javabasico2015;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class CienteIntegrationTest {

	@ClassRule
	public static TestRule rule = new LiquibaseRule();
	
	private static EntityManager manager = Persistence.createEntityManagerFactory("default")
															.createEntityManager();

	@Test
	public void test() {
		Pessoa pessoa = new PessoaFisica("João", LocalDate.of(2000, 10, 31));
		Cliente cliente = new Cliente(pessoa, BigDecimal.TEN);
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

}
