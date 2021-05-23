package br.com.zupacademy.gulherme.casadocodigo.DTO;

import java.math.BigDecimal;

import java.time.format.DateTimeFormatter;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Autor;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Livro;

public class DetalhesLivroDto {

	private String titulo;
	private String isbn;
	private int numeroDePaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String datapublicao;

	// porfavor de certo aqui é o Autor

	private DetalhesAutorDTO autor;

	public DetalhesLivroDto(Livro livro, Autor autor) {

		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.preco = livro.getPreço();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.datapublicao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
		this.autor = new DetalhesAutorDTO(livro.getAutor());

	}

	public DetalhesAutorDTO getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getDatapublicao() {
		return datapublicao;
	}

}
