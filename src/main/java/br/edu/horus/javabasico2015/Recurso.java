package br.edu.horus.javabasico2015;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Recurso {

	@Produces
	@ApplicationScoped
	public EntityManagerFactory getFactory(){
		return Persistence.createEntityManagerFactory("default");
	}
	
	@Produces
	@RequestScoped
	public EntityManager getManager(EntityManagerFactory factory){
		return factory.createEntityManager();
	}
	
	@Produces
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:hsqldb:file:target/test;hsqldb.lock_file=false;create=true");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
