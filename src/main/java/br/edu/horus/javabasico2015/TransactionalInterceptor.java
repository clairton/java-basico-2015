package br.edu.horus.javabasico2015;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Interceptor
@Transactional
public class TransactionalInterceptor {

	private EntityManager manager;
	
	@Inject
	public TransactionalInterceptor(EntityManager manager) {
		this.manager = manager;
	}
	
	@AroundInvoke
	public Object aoInvocar(InvocationContext context) throws Exception{
		try {
			manager.getTransaction().begin();
			System.out.println("slkdfhsakjhfkjsadfhjksadhf");
			Object object =  context.proceed();
			manager.getTransaction().commit();
			return object;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
}
