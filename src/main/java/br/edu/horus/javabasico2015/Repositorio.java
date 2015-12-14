package br.edu.horus.javabasico2015;

import java.sql.SQLException;

public interface Repositorio<T> {

	T salvar(T entidade) throws SQLException;
	
}
