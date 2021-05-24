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

import br.com.zupacademy.guilherme.casadocodigo.config.validacao.EstadoPertenceAPaisValidator;
import br.com.zupacademy.guilherme.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.guilherme.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Autor;
import br.com.zupacademy.guilherme.casadocodigo.modelo.Cliente;

@RestController
@RequestMapping("/cadastrarCliente")
public class NovoClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;


	@PostMapping
	@Transactional
	public String cadastrarCliente(@RequestBody @Valid ClienteForm form) {
		Cliente cliente = form.toModel();
		manager.persist(cliente);
		return cliente.toString();
	}
}
