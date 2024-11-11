package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Autor;

import java.util.ArrayList;
import java.util.List;

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
    
    public AutorForm(Autor autor) {
        this.nome = autor.getNome();
        this.sobrenome = autor.getSobrenome();
        this.nomeArtistico = autor.getNomeArtistico();
        this.nacionalidade = autor.getNacionalidade();
    }
    
    public Autor converteParaAutor() {
        return new Autor(this.nome, this.sobrenome, this.nomeArtistico, this.nacionalidade);
    }
    
    public List<AutorForm> converteParaAutorForm(List<Autor> autores) {
        List<AutorForm> autorForms = new ArrayList<>();
        
        for (Autor autor : autores) {
            AutorForm autorForm = new AutorForm(autor);
            autorForms.add(autorForm);
        }
        
        return autorForms;
    }
    
    public AutorForm converteParaAutorForm(Autor autor){
        return new AutorForm(autor.getNome(),
                autor.getSobrenome(),
                autor.getNomeArtistico(),
                autor.getNacionalidade());
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
