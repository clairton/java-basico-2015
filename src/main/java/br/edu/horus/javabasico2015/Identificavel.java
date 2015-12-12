package br.edu.horus.javabasico2015;

import java.lang.reflect.Field;

public class Identificavel {

	public Identificavel() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
			if(obj instanceof Item){
				try{
					///recuperamos o tipo
					Class<?> klazz = getClass();
					//os atributos do tipo
					Field[] fields = klazz.getDeclaredFields();
					//percorrendo os atributos
					for (Field field : fields) {
						//verifica se a anotação esta presente
						if(field.isAnnotationPresent(Identificador.class)){
							Object v1 = field.get(this);
							Object v2 = field.get(obj);
							if(v1 == null || !v1.equals(v2)){
								return false;
							}
						}
					}
				}catch(IllegalAccessException e){
					throw new RuntimeException(e);
				}
				return true;
			}
			return false;
			
	//		if(obj instanceof Item){
	//			Item item = (Item) obj;
	//			if(item.getNome() != null){
	//				return item.getNome().equalsIgnoreCase(this.nome);
	//			}
	//		}		
		}

}