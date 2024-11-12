package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Editora;

public class EditoraDTO {
    
	private Long id;
    private String nome;
    
    
    public EditoraDTO() {
    }
    
    public EditoraDTO(Long id, String nome) {
    	this.id = id;
    	this.nome = nome;
    }
    
    public EditoraDTO(Editora editora) {
        this.nome = editora.getNome();
    }
    
    public EditoraDTO converteParaDTO(Editora editora){
        return new EditoraDTO(editora.getId(), editora.getNome());
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
