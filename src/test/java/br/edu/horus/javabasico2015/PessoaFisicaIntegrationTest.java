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
public class PessoaFisicaIntegrationTest {

	@ClassRule
	public static TestRule rule = new LiquibaseRule();
	
	@Inject
	private EntityManager manager;

	@Test
	public void test() {
		Pessoa pessoa = new PessoaFisica("João", LocalDate.of(2000, 10, 31));
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
	}

}
