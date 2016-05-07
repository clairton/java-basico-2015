package br.edu.horus.javabasico2015;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

@RequestScoped
public class ServicoDao {
	private EntityManager manager;

	@Deprecated
	public ServicoDao() {
	}
	
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

	public <T>Collection<T> buscar(Class<T> tipo) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(tipo);
		q.from(tipo);
		TypedQuery<T> query = manager.createQuery(q);
		List<T> results = query.getResultList();
		return results;
	}

	public <T>T buscar(Class<T> tipo, Integer id) {
		return manager.find(tipo, id);
	}

	@Transactional
	public <T>void remover(T pedido) {
		manager.remove(pedido);
		manager.flush();
	}	
}















