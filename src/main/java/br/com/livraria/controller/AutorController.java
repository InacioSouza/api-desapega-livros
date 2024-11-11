package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.livraria.controller.dto.AutorDTO;
import br.com.livraria.repository.AutorRepository;
import br.com.livraria.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepo;
	
	@Autowired
	private AutorService autorService;

	@PostMapping
	ResponseEntity<?> cadastraAutor(@RequestBody AutorDTO autorDTO) {
		
		System.out.println("\n\n" + autorDTO.getNomeArtistico() + "\n\n");

		return autorService.cadastraAutor(autorDTO, autorRepo);
	}
	
	@GetMapping
	ResponseEntity<?> listaAutores() {
		return autorService.listaAutores(autorRepo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaAutorPorId(@PathVariable Long id) {
		return autorService.buscaPorId(autorRepo, id);
	}
}
