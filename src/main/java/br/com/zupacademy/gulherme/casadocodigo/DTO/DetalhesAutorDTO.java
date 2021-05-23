package br.com.zupacademy.gulherme.casadocodigo.DTO;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Autor;

public class DetalhesAutorDTO {

	private String nome;
	private String descricao;

	public DetalhesAutorDTO(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
