package br.edu.horus.javabasico2015;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

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
		@SuppressWarnings("unused")
		Object retorno = method.invoke(pedido, item);
	}
	
	@Test
	public void testSetPorReflection() throws Exception{
		//TODO limpar a lista de items a força
		Field field = pedido.getClass().getDeclaredField("items");
		field.setAccessible(true);//pq o elemento é privado
		/*
		 * cuidado na hora de setar o valor, nesse caso
		 * pode acontecer um problema pois mudei a estrutura de
		 * dados de List(ArrayList) para Set(HashSet), o mesmo
		 * não vai dar erro pois ambos implementam Collection
		 */
		Collection<Item> value = new HashSet<>();
		field.set(pedido, value);
	}
	
	@Test
	public void testString(){
		StringBuilder nome = new StringBuilder("abc");
		foo(nome);
		System.out.println(nome);
	}
	
	public void foo(StringBuilder nome){
		nome.append("def");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
