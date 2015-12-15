package br.edu.horus.javabasico2015;

import java.sql.SQLException;

public interface Repositorio<T> {

	@Transacional
	T salvar(T entidade) throws SQLException;
	
}
