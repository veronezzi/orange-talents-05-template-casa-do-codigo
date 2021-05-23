package br.com.zupacademy.guilherme.casadocodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Livro;
import br.com.zupacademy.guilherme.casadocodigo.repository.LivrosIdAndTituloRepository;

@RestController
@RequestMapping("/listarLivros")
public class ListaLivrosController {

	@Autowired
	LivrosIdAndTituloRepository LivrosRepository;

	@GetMapping
	@Transactional
	public List<Object> getSchool() {
	    List<Object> livros = LivrosRepository.getLivroIdAndName();
	    return livros;
	}
}
