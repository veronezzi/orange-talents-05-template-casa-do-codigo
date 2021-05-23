package br.com.zupacademy.guilherme.casadocodigo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotBlank String sumario;
	private @Min(20) BigDecimal preço;
	private @Min(100) int numeroDePaginas;
	private @NotBlank String isbn;
	@NotNull
	private LocalDate dataPublicacao;
	@ManyToOne
	private @Valid Autor autor;
	@ManyToOne
	private @Valid Categoria categoria;

	

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preço, @Min(100) int numeroDePaginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao,@NotNull @Valid Autor autor,@NotNull @Valid Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preço = preço;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
		// TODO Auto-generated constructor stub
		
	}
	
	



	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preço="
				+ preço + ", numeroDePaginas=" + numeroDePaginas + ", isbn=" + isbn + ", dataPublicacao="
				+ dataPublicacao + ", autor=" + autor + ", categoria=" + categoria + "]";
	}

}
