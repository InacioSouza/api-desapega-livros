package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Editora;

public class EditoraDTO {
    
    private String nome;
    
    
    public EditoraDTO() {
    }
    
    public EditoraDTO(String nome) {
    }
    
    public EditoraDTO(Editora editora) {
        this.nome = editora.getNome();
    }
    
    public EditoraDTO converteParaDTO(Editora editora){
        return new EditoraDTO(editora.getNome());
    }
    
    public Editora converteParaEditora(EditoraDTO editoraDTO) {
        return new Editora(this.nome);
    }
    
    public String getNome() {
        return nome;
    }
    
    public  void setNome(String nome){
        this.nome = nome;
    }
    
}
