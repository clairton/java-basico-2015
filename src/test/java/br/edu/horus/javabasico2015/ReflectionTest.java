package br.edu.horus.javabasico2015;

import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void testRecuperarMetodos() throws Exception{
		Class<?>[] parametros = new Class<?>[]{Item.class};
		Method method = Pedido.class.getMethod("remover", parametros);
		Pedido pedido = new Pedido();
		Item item = new Item("polenta", 4.9d);
		pedido.adicionar(item);
		method.invoke(pedido, item);
	}	
}
