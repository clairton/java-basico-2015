package br.edu.horus.javabasico2015;

import java.sql.Connection;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseConnection;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

public class LiquibaseExtension implements Extension{

	public void run(@Observes AfterDeploymentValidation even, BeanManager manager){
		Bean<?> bean = manager.getBeans(Connection.class).iterator().next();
        CreationalContext<?> ctx = manager.createCreationalContext(bean);
        Connection connection = (Connection) manager.getReference(bean, Connection.class, ctx);
		
		
		String changeLog = "changelogs/changelog-main.xml";
		ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
		DatabaseConnection database = new JdbcConnection(connection);
		try {
			if("true".equals(System.getProperty("br.edu.horus.javabasico2015.FORCE_UPDATE"))){				
				connection.createStatement().executeUpdate("update databasechangeloglock set locked=false;");
			}
		}catch(Exception e){}
		try{
			Liquibase liquibase = new Liquibase(changeLog, resourceAccessor, database);
			if("true".equals(System.getProperty("br.edu.horus.javabasico2015.DROP_ALL"))){				
				liquibase.dropAll();
			}
			liquibase.update(new Contexts(), new LabelExpression());
		} catch (LiquibaseException e) {
			throw new RuntimeException(e);
		}
	}
}
