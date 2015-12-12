package br.edu.horus.javabasico2015;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class ReflectionTest {
	Pedido pedido = new Pedido();
	Item item = new Item("polenta", 4.9d);
	
	@Before
	public void setUp(){
		pedido.limpar();
		pedido.adicionar(item);		
	}

	@Test
	public void testRecuperarMetodos() throws Exception{
		Class<?>[] parametros = new Class<?>[]{Item.class};
		Class<?> tipo = Class.forName("br.edu.horus.javabasico2015.Pedido");
		Method method = tipo.getMethod("remover", parametros);
		method.invoke(pedido, item);
	}
	
	@Test
	public void testConstruir() throws Exception{
		Class<?> tipo = Class.forName("br.edu.horus.javabasico2015.Pedido");
		Constructor<?> constructor = tipo.getConstructor();
		Object pedido = constructor.newInstance();
		Class<?>[] parametros = new Class<?>[]{Item.class};
		Method method = tipo.getMethod("remover", parametros);
		Object retorno = method.invoke(pedido, item);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
