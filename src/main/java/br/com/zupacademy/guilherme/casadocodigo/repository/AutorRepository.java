package br.com.zupacademy.guilherme.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Autor;

public interface AutorRepository extends  JpaRepository <Autor,Long>{

}
