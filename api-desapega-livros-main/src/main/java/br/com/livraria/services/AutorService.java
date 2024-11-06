package br.com.livraria.services;

import java.util.List;
import java.util.Optional;

import br.com.livraria.controller.form.AutorForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.livraria.controller.dto.AutorDTO;
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
					.body(new Response("Sobreome do autor não especificado", 400));

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

		autor = autorRepo.save(autorForm.converteParaAutor(autorForm));

		if (autor == null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new Response("Autor não cadastrado", 422));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Autor cadastrado", 201));
	}

	public ResponseEntity<?> listaAutores(AutorRepository autorRepo) {

		List<Autor> autores = (List<Autor>) autorRepo.findAll();

		if (autores.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhum autor encontrado", 404));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new AutorDTO().converteParaAutorDTO(autores));

	}

	public ResponseEntity<?> getById(AutorRepository autorRepo, Long id) {

		Optional autorOPT = null;

		autorOPT = autorRepo.findById(id);

		Autor autor = (Autor) autorOPT.get();

		if (autor == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Autor não encontrado", 404));
		}
        return ResponseEntity.status(HttpStatus.OK).body(autor);
	}
}
