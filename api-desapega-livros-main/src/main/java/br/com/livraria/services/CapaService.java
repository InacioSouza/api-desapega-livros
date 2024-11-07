package br.com.livraria.services;

import br.com.livraria.controller.form.CapaForm;
import br.com.livraria.repository.CapaRepository;
import br.com.livraria.repository.entity.Autor;
import br.com.livraria.repository.entity.Capa;
import br.com.livraria.services.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CapaService {

    @Transactional
    public ResponseEntity cadastraCapa(CapaForm capaForm, CapaRepository capaRepo) {

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

        }

        Capa capa = null;

        capa = capaRepo.buscaCapaPorTodosOsAtributos(capaForm.getNome(), capaForm.getTipo(), capaForm.getCategoria());

        if (capa != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new Response("Autor presente no banco de dados", 409));
        }

        capa = capaRepo.save(capaForm.converteParaCapa(capaForm));

        if (capa == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new Response("Autor não cadastrado", 422));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Autor cadastrado", 201));
    }
}
