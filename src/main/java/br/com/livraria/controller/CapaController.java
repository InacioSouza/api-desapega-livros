package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.livraria.controller.form.MetaDadosImagem;
import br.com.livraria.repository.CapaRepository;
import br.com.livraria.repository.CategoriaRepository;
import br.com.livraria.services.CapaService;

@RestController
@RequestMapping("/capa")
public class CapaController {

	@Autowired
	CapaRepository capaRepo;
	
	@Autowired
	private CategoriaRepository catRepo;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	ResponseEntity<?> cadastraCapa(@RequestParam("imagem") MultipartFile imagem,
			@RequestPart("mtdImagem") MetaDadosImagem mtdImagem) {

		return new CapaService(catRepo).cadastraCapa(imagem, mtdImagem, capaRepo);
	}

}
