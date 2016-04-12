package br.edu.horus.javabasico2015;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseConnection;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

public class LiquibaseRule implements TestRule {

	private Connection connection;
	
	public LiquibaseRule(Connection connection) {
		this.connection = connection;
	}

	public LiquibaseRule() {
		this(createConnection());
	}

	private static Connection createConnection() {
		try {
			return DriverManager.getConnection("jdbc:hsqldb:file:target/test;hsqldb.lock_file=false;create=true");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Statement apply(Statement base, Description description) {
		String changeLog = "changelogs/changelog-main.xml";
		ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
		DatabaseConnection database = new JdbcConnection(connection);
		try {
			connection.createStatement()
							.executeUpdate("update databasechangeloglock set locked=false;");
		}catch(Exception e){}
		try{
			Liquibase liquibase = new Liquibase(changeLog, resourceAccessor, database);
			liquibase.dropAll();
			liquibase.update(new Contexts(), new LabelExpression());
		} catch (LiquibaseException e) {
			throw new RuntimeException(e);
		}
		return base;
	}

}
