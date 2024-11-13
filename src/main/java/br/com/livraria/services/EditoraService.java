package br.com.livraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.livraria.controller.dto.EditoraDTO;
import br.com.livraria.controller.form.EditoraForm;
import br.com.livraria.repository.EditoraRepository;
import br.com.livraria.repository.entity.Editora;
import br.com.livraria.services.response.Response;

@Service
public class EditoraService {
    
    @Transactional
    public ResponseEntity<?> buscaPorId(EditoraRepository editoraRepo, Long id) {
        Optional<Editora> editora = editoraRepo.findById(id);
        
        if (editora.isPresent()) {
            return ResponseEntity.ok(editora.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Nenhuma editora encontrada", 404));
        }
    }
}
