package br.com.zupacademy.guilherme.casadocodigo.config.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.guilherme.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Estado;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteForm form = (ClienteForm) target;

		@NotNull
		Pais pais = manager.find(Pais.class, form.getIdPais());
		Estado estado = manager.find(Estado.class, form.getIdEstado());
		if (estado.pertenceAPais(pais)) {
			errors.rejectValue("idEstado", null, "este estado não é o do país selecionado");
		}

	}

}