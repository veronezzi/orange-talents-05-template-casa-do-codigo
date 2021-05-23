package br.com.zupacademy.guilherme.casadocodigo.config.validacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {IdUnicoValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface IdUnico {

String message() default "Esse campo possui um Id duplicado favor realizar a alteração.";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> domainClass();
}