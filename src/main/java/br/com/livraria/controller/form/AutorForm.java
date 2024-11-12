package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Autor;

public class AutorForm {
    
    private String nome;
    
    private String sobrenome;
    
    private String nomeArtistico;
    
    private String nacionalidade;
    
    public AutorForm() {
    
    }
    
    public AutorForm(String nome, String sobrenome, String nomeArtistico, String nacionalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nomeArtistico = nomeArtistico;
        this.nacionalidade = nacionalidade;
    }
    
    public Autor converteParaAutor() {
        return new Autor(this.nome, this.sobrenome, this.nomeArtistico, this.nacionalidade);
    }
    
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getNomeArtistico() {
        return nomeArtistico;
    }
    
    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }
    
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    public String toString() {
        return "AutorDTO [nome=" + nome + ", sobrenome=" + sobrenome + ", nomeArtistico=" + nomeArtistico
                + ", nacionalidade=" + nacionalidade + "]";
    }
    
    
    
}
