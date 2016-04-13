package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		Item item = new Item("Pão", 1.01);
		System.out.println(item.getNome());
	}
	
	@Test
	public void testIsEquals(){
		Identificavel uva = new Item("Uva", 3.02d);
		Identificavel morango = new Item("Morango", 3.02d);
		assertFalse(uva.equals(morango));
	}
	
	@Test
	public void testValidacao(){
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Item item = new Item("s", 0.00);
		Set<ConstraintViolation<Item>> erros = validator.validate(item);
		for (ConstraintViolation<Item> erro : erros) {
			System.err.println("O campo " + erro.getRootBeanClass().getSimpleName() +"#"+ erro.getPropertyPath() +" " + erro.getMessage());
		}
	}
}


















