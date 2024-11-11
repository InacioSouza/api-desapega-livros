package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.*;

import java.time.LocalDateTime;


public class LivroDTO {
    
    private String titulo;
    
    private LocalDateTime dtPublicacao;
    
    private String descricao;
    
    private Capa capa;
    
    
    public LivroDTO() {
    }
    
    public LivroDTO(String titulo, LocalDateTime dtPublicacao, String descricao, Capa capa) {
    }
    
    
    public LivroDTO converteParaDTO(Livro livro){
        return new LivroDTO(livro.getTitulo(),
                livro.getDtPublicacao(),
                livro.getDescricao(),
                livro.getCapa());
    }
    
    public Livro converteParaLivro() {
        return new Livro(this.titulo, this.dtPublicacao, this.descricao, this.capa);
    }
    
    
    
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public LocalDateTime getDtPublicacao() {
        return dtPublicacao;
    }
    
    public void setDtPublicacao(LocalDateTime dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Capa getCapa() {
        return capa;
    }
    
    public void setCapa(Capa capa) {
        this.capa = capa;
    }
}
