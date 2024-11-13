package br.com.livraria.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.livraria.controller.dto.CategoriaDTO;
import br.com.livraria.controller.form.CategoriaForm;
import br.com.livraria.repository.CategoriaRepository;
import br.com.livraria.repository.entity.Categoria;
import br.com.livraria.services.response.Response;

@Service
public class CategoriaService {
	
	public ResponseEntity<?> cadastraCategoria(CategoriaForm categoriaForm,
			CategoriaRepository categoriaRepo) {
		if (categoriaForm == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Categoria null", 400));
		} else if (categoriaForm.getNome() == null || categoriaForm.getNome().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Nome da categoria não especificado", 400));
		}
		
		Categoria categoria = null;
		
		categoria = categoriaRepo.findByNome(categoriaForm.getNome());
		
		if (categoria != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new Response("Categoria presente no banco de dados", 409));
		}
		
		categoria = categoriaRepo.save(categoriaForm.converteParaCategoria());
		
		if (categoria == null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new Response("Categoria não cadastrada", 422));
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Categoria cadastrada", 201));
	}
	
	public ResponseEntity<?> listaCategorias(CategoriaRepository categoriaRepo) {

		List<Categoria> categorias = (List<Categoria>) categoriaRepo.findAll();

		if (categorias.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhuma categoria encontrada", 404));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new CategoriaDTO().converteParaCategoriaDTO(categorias));

	}

}