package br.edu.horus.javabasico2015;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Dependent
public class ServicoDao {
	private EntityManager manager;

	@Inject
	public ServicoDao(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public <T> T salvar(T entidade){
		manager.persist(entidade);
		manager.flush();
		return entidade;
	}
}
