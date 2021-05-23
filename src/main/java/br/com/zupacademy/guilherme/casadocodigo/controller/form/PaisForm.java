package br.com.zupacademy.guilherme.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.guilherme.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Pais;

public class PaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}

}
