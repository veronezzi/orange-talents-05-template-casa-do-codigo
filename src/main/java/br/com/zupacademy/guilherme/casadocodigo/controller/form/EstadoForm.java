package br.com.zupacademy.guilherme.casadocodigo.controller.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zupacademy.guilherme.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Estado;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Pais;

public class EstadoForm {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	@NotNull
	//@UniqueValue(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public EstadoForm(@NotBlank String nome, Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public Estado toModel(EntityManager manager) {
		return new Estado(nome,manager.find(Pais.class, idPais));
	}
	

}
