package br.com.zupacademy.guilherme.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.guilherme.casadocodigo.controller.form.PaisForm;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Estado;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Pais;

@RestController
@RequestMapping("/cadastrarEstado")
public class NovoEstadoController {
	
	@Autowired
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastrarEstado(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.toModel(manager);
		manager.persist(estado);
		
		return estado.toString();
	}
	

}
