package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.livraria.controller.form.AutorForm;
import br.com.livraria.repository.AutorRepository;
import br.com.livraria.services.AutorService;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepo;
	
	@Autowired
	AutorService autorService;

	@PostMapping
	ResponseEntity<?> cadastraAutor(@RequestBody AutorForm autorForm) {
		
		return autorService.cadastraAutor(autorForm, autorRepo);
	}

	// Fazer com paginação
	@GetMapping
	ResponseEntity<?> listaAutores() {
		return autorService.listaAutores(autorRepo);
	}
	
	@GetMapping
	ResponseEntity<?>buscaPorId(@PathVariable Long id){
		return autorService.buscaPorId(autorRepo, id);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<?> ModificaAutor(@PathVariable Long id,@RequestBody AutorForm autorForm){
		return autorService.modificaAutor(autorRepo, id, autorForm);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> DeletaPorId(@PathVariable Long id){
		return autorService.deletaPorId(autorRepo, id);
	}
	
	@DeleteMapping("/batch")
	public ResponseEntity<?> deleteList(@RequestBody List<Long> ids) {
		return autorService.deletaLista(autorRepo, ids);
	}
	
}
