package br.com.zupacademy.guilherme.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.guilherme.casadocodigo.config.validacao.UniqueValue;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Categoria;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

}
