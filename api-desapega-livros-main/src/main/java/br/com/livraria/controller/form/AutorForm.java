package br.com.livraria.controller.form;

import java.util.List;
import java.util.stream.Collectors;

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

    public AutorForm(Autor autor) {
        this.nome = autor.getNome();
        this.sobrenome = autor.getSobrenome();
        this.nomeArtistico = autor.getNomeArtistico();
        this.nacionalidade = autor.getNacionalidade();
    }

    public Autor converteParaAutor(AutorForm autorForm) {
        return new Autor(
                autorForm.getNome(),
                autorForm.getSobrenome(),
                autorForm.getNomeArtistico(),
                autorForm.getNacionalidade()
        );
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String toString() {
        return "AutorDTO [nome=" + nome + ", sobrenome=" + sobrenome + ", nomeArtistico=" + nomeArtistico
                + ", nacionalidade=" + nacionalidade + "]";
    }

    public List<AutorForm> converteParaAutorForm(List<Autor> autores) {

        return autores.stream().map(AutorForm::new).collect(Collectors.toList());

    }

}
