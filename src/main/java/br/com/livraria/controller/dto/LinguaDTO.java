package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Lingua;
import br.com.livraria.repository.entity.Livro;

import java.util.ArrayList;
import java.util.List;

public class LinguaDTO {
    
    private String nome;
    
    private List<Livro> livros = new ArrayList<>();
    
    
    public LinguaDTO() {
    }
    
    public LinguaDTO(String nome) {
    }
    
    public LinguaDTO(String nome, List<Livro> livros) {
    }
    
    
    public LinguaDTO converteParaDTO(Lingua lingua){
        return new LinguaDTO(lingua.getNome(), lingua.getLivros());
    }
    
    public Lingua converteParaLingua(LinguaDTO linguaDTO) {
        return new Lingua(this.nome, this.livros);
    }
    
    public String getNome() {
        return nome;
    }
    
    public  void setNome(String nome){
        this.nome = nome;
    }
    
}
