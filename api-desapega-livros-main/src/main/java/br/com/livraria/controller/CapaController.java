package br.com.livraria.controller;

import br.com.livraria.controller.form.CapaForm;
import br.com.livraria.repository.CapaRepository;
import br.com.livraria.services.CapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capa")
public class CapaController {
    @Autowired
    CapaRepository capaRepo;

    @PostMapping
    ResponseEntity<?> cadastraCapa(@RequestBody CapaForm capaForm) {

        return new CapaService().cadastraCapa(capaForm, capaRepo);
    }
}
