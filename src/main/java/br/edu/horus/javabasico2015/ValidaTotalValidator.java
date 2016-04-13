package br.edu.horus.javabasico2015;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaTotalValidator implements ConstraintValidator<ValidaTotal, Pedido> {

	
	@Override
	public void initialize(ValidaTotal annotation) {
	}

	@Override
	public boolean isValid(Pedido pedido, ConstraintValidatorContext context) {
		Double soma = pedido.getItems().stream().mapToDouble(i -> i.getValor()).sum();
		return pedido.getTotal().equals(soma);
	}

}
