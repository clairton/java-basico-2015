package br.edu.horus.javabasico2015;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class RepositorioHandler implements InvocationHandler {

	private Repositorio<?> repositorio;
	private Connection conexao;

	public RepositorioHandler(Repositorio<?> repositorio,
			Connection conexao) {
		this.repositorio = repositorio;
		this.conexao = conexao;
	}

	@Override
	public Object invoke(Object proxy, 
				Method method, 
				Object[] args) throws Throwable {
		
		if(method.isAnnotationPresent(Transacional.class)){			
			conexao.setAutoCommit(false);
			Object retorno;
			try{
				retorno = method.invoke(repositorio, args);
				conexao.commit();
			}catch(Exception e){
				conexao.rollback();
				throw e;
			}
			return retorno;
		}
		return method.invoke(repositorio, args);		
	}

}
