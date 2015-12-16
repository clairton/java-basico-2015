package br.edu.horus.javabasico2015;

public class DecoratorTest {

	interface Foo{
		void bar();
	}
	
	class FooImpl implements Foo{
		@Override
		public void bar() {
			System.err.println("faz alguma coisa");
		}	
	}
	
	
	class Xpto implements Foo{
		private Foo foo = new FooImpl();
		
		@Override
		public void bar() {
			foo.bar();
		}
	}
	{
		Foo f = new Xpto();
	}
}
