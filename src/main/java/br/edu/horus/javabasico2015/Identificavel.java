package br.edu.horus.javabasico2015;

import java.lang.reflect.Field;

public class Identificavel {

	public Identificavel() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass().isInstance(obj)) {
			try {
				/// recuperamos o tipo
				Class<?> klazz = getClass();				
				while(klazz != null && klazz != Object.class){				
					// os atributos do tipo
					Field[] fields = klazz.getDeclaredFields();
					// percorrendo os atributos
					for (Field field : fields) {
						// verifica se a anotação esta presente
						if (field.isAnnotationPresent(Identificador.class)) {
							Identificador annotation = field.getAnnotation(Identificador.class);
							
							field.setAccessible(true);
							Object v1 = field.get(this);
							Object v2 = field.get(obj);
							
							if(!annotation.isCaseSensitive()){
								if(v1 != null && !(v1 instanceof String)){
									throw new RuntimeException(
											"Para usar Identificador#isCaseSensitive:false deve ser String"
											);
								}							
								if(v1 == null || !v1.toString().equalsIgnoreCase(v2.toString())){
									return false;
								}
							} else if (v1 == null || !v1.equals(v2)) {
								return false;
							}
						}
					}
					klazz = klazz.getSuperclass();
				}
				
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
			return true;
		}
		return false;
	}
}