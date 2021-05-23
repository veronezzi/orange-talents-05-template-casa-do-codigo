package br.com.zupacademy.guilherme.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.zupacademy.guilherme.casadocodigo.controller.form.PaisForm;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Pais;

@RestController
@RequestMapping("/cadastrarPais")
public class NovoPaisController {
	

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastrarPais(@RequestBody @Valid PaisForm form) {
		Pais pais = form.toModel();
		manager.persist(pais);
		return pais.toString();
	}


}
