package br.com.zupacademy.guilherme.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guilherme.casadocodigo.config.validacao.IdUnico;
import br.com.zupacademy.guilherme.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.guilherme.casadocodigo.config.validacao.ValidadorDeCpfCnpj;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Cliente;

public class ClienteForm {

	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	@NotBlank
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@ValidadorDeCpfCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	//@IdUnico(domainClass = Cliente.class, fieldName = "id")
	private Long idPais;
	@NotNull
	//@IdUnico(domainClass = Cliente.class, fieldName = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel() {
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
				this.cidade, this.idPais, this.idEstado, this.telefone, this.cep);
	}

	public Object getIdPais() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getIdEstado() {
		// TODO Auto-generated method stub
		return null;
	}

}
