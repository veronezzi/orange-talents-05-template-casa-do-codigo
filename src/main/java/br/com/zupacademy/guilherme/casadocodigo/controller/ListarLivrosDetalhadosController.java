package br.com.zupacademy.guilherme.casadocodigo.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guilherme.casadocodigo.modelo.Livro;

import br.com.zupacademy.guilherme.casadocodigo.repository.LivrosIdAndTituloRepository;
import br.com.zupacademy.gulherme.casadocodigo.DTO.DetalhesLivroDto;

@RestController
@RequestMapping("/detalharLivros")
public class ListarLivrosDetalhadosController {

	@Autowired
	private LivrosIdAndTituloRepository LivrosIdAndTituloRepository;

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalhesLivroDto> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = LivrosIdAndTituloRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroDto(livro.get(), null));
		}
		return ResponseEntity.notFound().build();
	}

}
