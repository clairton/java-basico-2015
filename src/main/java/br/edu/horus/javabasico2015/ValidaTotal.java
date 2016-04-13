package br.edu.horus.javabasico2015;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidaTotalValidator.class)
public @interface ValidaTotal {
	String message() default "{br.edu.horus.javabasico2015.ValidaTotal.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
