package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.controller.dto.AutorDTO;
import br.com.livraria.repository.AutorRepository;
import br.com.livraria.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepo;

	@PostMapping
	ResponseEntity<?> cadastraAutor(@RequestBody AutorDTO autorDTO) {
		
		System.out.println("\n\n" + autorDTO.getNomeArtistico() + "\n\n");

		return new AutorService().cadastraAutor(autorDTO, autorRepo);
	}

	// Fazer com paginação
	@GetMapping
	ResponseEntity<?> listaAutores() {
		return new AutorService().listaAutores(autorRepo);
	}
}
