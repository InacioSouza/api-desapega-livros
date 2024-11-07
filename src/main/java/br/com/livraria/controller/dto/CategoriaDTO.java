package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Livro;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {

    private String nome;

    private List<Livro> livros = new ArrayList<>();

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
