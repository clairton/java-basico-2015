package br.edu.horus.javabasico2015;
import org.junit.Test;
public class SingletonExemploTest {	
	@Test
	public void test(){
		/*
		 * não consigo instanciar chamando o construtor
		 * por ele ser privado
		 */
		//new Foo();
		Foo foo1 = Foo.getInstance();
		foo1.setBar("abc");
		Foo foo2 = Foo.getInstance();
		System.err.println(foo2.getBar());//abc
	}
}
class Foo{
	private static Foo instance;
	
	private String bar;
	
	private Foo() {}
	
	
	public static Foo getInstance(){
		if(instance == null){
			instance = new Foo();
		}
		return instance;
	}
	
	
	public void setBar(String bar) {
		this.bar = bar;
	}
	
	public String getBar() {
		return bar;
	}
}