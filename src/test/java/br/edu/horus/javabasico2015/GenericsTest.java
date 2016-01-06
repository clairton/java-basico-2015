package br.edu.horus.javabasico2015;

public class GenericsTest {
	class Box<T>{
		T d;	
		public Box(T d) {
			super();
			this.d = d;
		}
		T getDefault(){
			return d;
		}
	}	
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public void test(){
		//em tempo de compilação
		Box<String> b = new Box<String>("xpto");
		String x = b.getDefault();

		//em tempo de execução
		Box b2 = new Box("");
		String x2 = (String) b2.getDefault();
	}	
}
