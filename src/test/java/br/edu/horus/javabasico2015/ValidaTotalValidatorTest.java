package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidator;

import org.junit.Before;
import org.junit.Test;

public class ValidaTotalValidatorTest {
	private ConstraintValidator<ValidaTotal, Pedido> validador;
	
	@Before
	public void init(){
		validador = new ValidaTotalValidator();
	}
	
	@Test
	public void testIsValid() {
		Pedido pedido = new Pedido();
		pedido.adicionar(new Item("xpt", 0.99));
		pedido.adicionar(new Item("xpto", 0.65));
		pedido.totalizar();
		assertTrue(validador.isValid(pedido, null));
	}
	
	@Test
	public void testIsInvalidWhenIsGreater() {
		Pedido pedido = new Pedido(){
			@Override
			public Double getTotal() {
				return 0.01;
			}
		};
		pedido.adicionar(new Item("abc", 0.02));
		assertFalse(validador.isValid(pedido, null));
	}
	
	@Test
	public void testIsInvalidWhenIsLess() {
		Pedido pedido = new Pedido(){
			@Override
			public Double getTotal() {
				return 0.01;
			}
		};
		pedido.adicionar(new Item("Batata", 0.02));
		pedido.totalizar();
		assertFalse(validador.isValid(pedido, null));
	}
}


