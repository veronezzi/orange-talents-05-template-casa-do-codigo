package br.com.zupacademy.guilherme.casadocodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Livro;
import br.com.zupacademy.guilherme.casadocodigo.config.validacao.IdUnico;
import br.com.zupacademy.guilherme.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Autor;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Categoria;

public class LivroForm {

	@NotBlank(message = "Nome é necessario")
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preço;
	@Min(100)
	private int numeroDePaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	//@IdUnico(domainClass = Livro.class, fieldName = "id")
	private Long idCategoria;
	@NotNull
	//@IdUnico(domainClass = Livro.class, fieldName = "id")
	private Long idAutor;

	public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preço, @Min(100) int numeroDePaginas, @NotBlank String isbn, @NotNull Long idCategoria,
			@NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preço = preço;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;

		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull
		Autor autor = manager.find(Autor.class, idAutor);

		@NotNull
		Categoria categoria = manager.find(Categoria.class, idCategoria);

		return new Livro(titulo, resumo, sumario, preço, numeroDePaginas, isbn, dataPublicacao, autor, categoria);
	}

}
