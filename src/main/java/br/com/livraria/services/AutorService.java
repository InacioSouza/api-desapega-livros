package br.com.livraria.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.livraria.controller.dto.AutorDTO;
import br.com.livraria.controller.form.AutorForm;
import br.com.livraria.repository.AutorRepository;
import br.com.livraria.repository.entity.Autor;
import br.com.livraria.services.response.Response;

@Service
public class AutorService {

	@Transactional
	public ResponseEntity cadastraAutor(AutorForm autorForm, AutorRepository autorRepo) {

		if (autorForm == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Autor null", 400));

		} else if (autorForm.getNome() == null || autorForm.getNome().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Nome do autor não especificado", 400));

		} else if (autorForm.getSobrenome() == null || autorForm.getSobrenome().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Sobrenome do autor não especificado", 400));

		} else if (autorForm.getNacionalidade() == null || autorForm.getNacionalidade().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Nacionalidade do autor não especificado", 400));

		}

		Autor autor = null;

		autor = autorRepo.buscaAutorPorTodosOsAtributos(autorForm.getNome(), autorForm.getSobrenome(),
				autorForm.getNacionalidade());

		if (autor != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new Response("Autor presente no banco de dados", 409));
		}

		autor = autorRepo.save(autorForm.converteParaAutor());

		if (autor == null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new Response("Autor não cadastrado", 422));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Autor cadastrado", 201));
	}
	
	public ResponseEntity<?> modificaAutor(AutorRepository autorRepo,Long id, AutorForm autorForm){
		
		Optional<Autor> autorExistente = autorRepo.findById(id);
		
		if (autorExistente.isPresent()) {
			
			Autor autor = autorExistente.get();
			if (autorForm.getNome()==null || autorForm.getNome().isEmpty()){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new Response("Nome do autor não especificado", 400));
			}else if (autorForm.getSobrenome() == null || autorForm.getSobrenome().isEmpty()){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new Response("Sobrenome do autor não especificado", 400));
			} else if (autorForm.getNacionalidade() == null || autorForm.getNacionalidade().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new Response("Nacionalidade do autor não especificado", 400));
			}
			
			autor.setNome(autorForm.getNome());
			autor.setSobrenome(autorForm.getSobrenome());
			autor.setNomeArtistico(autorForm.getNomeArtistico());
			autor.setNacionalidade(autorForm.getNacionalidade());
	
			autorRepo.save(autor);
			return ResponseEntity.ok(autor);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhum autor encontrado", 404));
		}
		
	}
	
	public ResponseEntity<?> listaAutores(AutorRepository autorRepo) {

		List<Autor> autores = (List<Autor>) autorRepo.findAll();

		if (autores.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhum autor encontrado", 404));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new AutorDTO().converteParaAutorDTO(autores));

	}
	
	public ResponseEntity<?> buscaPorId(AutorRepository autorRepo, Long id){
		Optional<Autor> autor = autorRepo.findById(id);
		
		if (autor.isPresent()) {
			return ResponseEntity.ok(autor.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhum autor encontrado", 404));
		}
	}
	
	
	
	public ResponseEntity<?> deletaPorId(AutorRepository autorRepo, Long id) {
		Optional<Autor> autor = autorRepo.findById(id);
		
		if (autor.isPresent()) {
			autorRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Response("ID Deletado: " + id, 200));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhum autor encontrado", 404));
		}
	}
	
	public ResponseEntity<?> deletaLista(AutorRepository autorRepo, List<Long> ids){
		List<Long> idsInvalidos = ids.stream()
				.filter(id -> !autorRepo.existsById(id))
				.collect(Collectors.toList());
		
		if (!idsInvalidos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new Response("IDs não encontrados: " + idsInvalidos, 404));
		}
		
		autorRepo.deleteAllById(ids);
		return ResponseEntity.status(HttpStatus.OK).body(new Response("IDs Deletados: " + ids, 200));
	}
}
