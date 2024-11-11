package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Lingua;
import br.com.livraria.repository.entity.Livro;

import java.util.ArrayList;
import java.util.List;

public class LinguaForm {
    
    private String nome;
    
    private List<Livro> livros = new ArrayList<>();
    
    
    public LinguaForm() {
    }
    
    public LinguaForm(String nome) {
    }
    
    public LinguaForm(String nome, List<Livro> livros) {
    }
    
    
    public LinguaForm converteParaForm(Lingua lingua){
        return new LinguaForm(lingua.getNome(),
                lingua.getLivros());
    }
    
    public Lingua converteParaLingua(LinguaForm linguaForm) {
        return new Lingua(linguaForm.getNome(),
                linguaForm.getLivros());
    }
    
    public String getNome() {
        return nome;
    }
    
    public  void setNome(String nome){
        this.nome = nome;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
