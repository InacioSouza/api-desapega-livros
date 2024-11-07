package br.com.livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.livraria.controller.form.CapaForm;
import br.com.livraria.repository.CapaRepository;
import br.com.livraria.repository.CategoriaRepository;
import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Categoria;
import br.com.livraria.services.response.Response;

@Service
public class CapaService {

	@Autowired
	CategoriaRepository catRepo;

	@Transactional
	public ResponseEntity<?> cadastraCapa(CapaForm capaForm, CapaRepository capaRepo) {

		if (capaForm == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Capa null", 400));

		} else if (capaForm.getNome() == null || capaForm.getNome().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Nome da capa não especificado", 400));

		} else if (capaForm.getTipo() == null || capaForm.getTipo().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Tipo da capa não especificado", 400));

		} else if (capaForm.getDescricao() == null || capaForm.getDescricao().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Descrição da capa não especificado", 400));
		} else if (capaForm.getImagem() == null || capaForm.getImagem().length == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("imagem não adicionada", 400));
		}

		Categoria cat = catRepo.findByNome(capaForm.getCategoriaForm().getNome());

		if (cat == null) {
			catRepo.save(capaForm.getCategoriaForm().converteParaCategoria());
		}

		Capa capa = null;

		capa = capaRepo.buscaCapaPorTodosOsAtributos(capaForm.getNome(), capaForm.getTipo(), cat, capaForm.getImagem());

		if (capa != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new Response("Capa presente no banco de dados", 409));

		}

		capa = capaForm.converteParaCapa();
		capa.setCategoria(cat);

		capa = capaRepo.save(capa);

		if (capa == null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new Response("Capa não cadastrada", 422));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Capa cadastrada", 201));
	}
}
