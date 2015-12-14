package br.edu.horus.javabasico2015;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioItem implements Repositorio<Item> {
	private Connection conexao;
	
	public RepositorioItem(Connection conexao) {
		this.conexao = conexao;
	}
	
	@Override
	public Item salvar(Item entidade) throws SQLException {
		String sql = "INSERT INTO itens (nome, valor) VALUES (?, ?)";
		//prepara a inserção
		PreparedStatement statement = conexao.prepareStatement(
			sql, 
			Statement.RETURN_GENERATED_KEYS
		);
		//seta os valor para as colunas presente na string sql
		statement.setString(1, entidade.getNome());
		statement.setDouble(2, entidade.getValor());
		
		//executa o comando no banco de dados
		statement.executeQuery();
		
		//retorna os dados gerados automaticamente pelo banco
		ResultSet keys = statement.getGeneratedKeys();
		
		if(keys.next()){
			entidade.setId(keys.getInt(1));
		}
		
		return entidade;
	}

}
