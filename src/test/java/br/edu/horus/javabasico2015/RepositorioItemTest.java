package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class RepositorioItemTest {
	private Connection conexao;
	private Repositorio<Item> repositorio;
	
	@Before
	public void init() throws SQLException{
		String sql = "DROP TABLE itens IF EXISTS; "
		+ "CREATE TABLE itens(id INTEGER GENERATED "
		+ "BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1)"
		+ "PRIMARY KEY, "
		+ "nome VARCHAR(20) NOT NULL,"
		+ "valor DECIMAL(10, 2) NOT NULL);";
	
		String url = "jdbc:hsqldb:file:target/sample";
		conexao = DriverManager.getConnection(url);
		
		conexao.createStatement().executeQuery(sql);
		
		repositorio = RepositorioItem.getInstance(conexao);
	}

	@Test
	public void test() throws SQLException {
		Item item = new Item("Abacate", 2.5d);
		repositorio.salvar(item);
		assertNotNull(item.getId());
	}
}














