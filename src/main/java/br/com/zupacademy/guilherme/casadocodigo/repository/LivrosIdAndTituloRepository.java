package br.com.zupacademy.guilherme.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Livro;

public interface LivrosIdAndTituloRepository extends JpaRepository<Livro, Long >{
	
	 @Query("select s.id, s.titulo from Livro s")
	    List<Object> getLivroIdAndName();
}
