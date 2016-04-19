package br.edu.horus.javabasico2015;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Recurso {

	@Produces
	public EntityManagerFactory getFactory(){
		return Persistence.createEntityManagerFactory("default");
	}
	
	@Produces
	public EntityManager getManager(EntityManagerFactory factory){
		return factory.createEntityManager();
	}
}
