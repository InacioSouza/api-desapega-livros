package br.com.livraria.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.livraria.controller.form.MetaDadosImagem;
import br.com.livraria.repository.CapaRepository;
import br.com.livraria.repository.CategoriaRepository;
import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Categoria;
import br.com.livraria.services.response.Response;

@Service
public class CapaService {

	private final CategoriaRepository catRepo;

	public CapaService(CategoriaRepository catRepo) {
		this.catRepo = catRepo;
	}

	@Transactional
	public ResponseEntity<?> cadastraCapa(MultipartFile imagem, MetaDadosImagem mtdImagem, CapaRepository capaRepo) {
		
		System.out.println("\n\n categoria foi adicionada? " + mtdImagem.getCategoria().getNome() + "\n\n");


		if (mtdImagem == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("imagem não adicionada", 400));
		}

		if (mtdImagem.getNome() == null || mtdImagem.getNome().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Nome da capa não especificado", 400));

		} else if (mtdImagem.getCategoria() == null || mtdImagem.getCategoria().getNome().isEmpty()) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Categoria  não especificada", 400));

		} else if (mtdImagem.getTipo() == null || mtdImagem.getTipo().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Tipo da capa não especificado", 400));

		} else if (mtdImagem.getDescricao() == null || mtdImagem.getDescricao().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Descrição da capa não especificado", 400));
		}

		Categoria cat = catRepo.findByNome(mtdImagem.getCategoria().getNome());

		if (cat == null) {
			catRepo.save(mtdImagem.getCategoria().converteParaCategoria());
		}

		Capa capa = null;

		byte[] imagemBytes;

		try {
			imagemBytes = imagem.getBytes();
		} catch (IOException e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new Response("Erro ao tentar cadastrar imagem", 422));
		}

		capa = capaRepo.buscaCapaPorTodosOsAtributos(mtdImagem.getNome(), mtdImagem.getTipo(), cat, imagemBytes);

		if (capa != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new Response("Capa presente no banco de dados", 409));

		}

		capa = new Capa();

		mtdImagem.adicionaDadosEmCapa(capa);

		capa.setCategoria(cat);
		capa.setImagem(imagemBytes);

		capa = capaRepo.save(capa);

		if (capa == null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new Response("Capa não cadastrada", 422));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Capa cadastrada", 201));
	}
}
