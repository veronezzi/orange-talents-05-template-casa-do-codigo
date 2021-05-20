package br.com.zupacademy.guilherme.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.guilherme.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Autor;

import javax.validation.constraints.Email;

public class AutorForm {

	@NotBlank(message = "Nome é necessario")
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
