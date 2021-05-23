package br.com.zupacademy.guilherme.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Livro;



@RestController
@RequestMapping("/cadastrarLivro")
public class NovoLivroController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastrarLivro(@RequestBody @Valid LivroForm form) {
		Livro novolivro = form.toModel(manager);
		manager.persist(novolivro);
		return novolivro.toString();
	}
	
	

}
