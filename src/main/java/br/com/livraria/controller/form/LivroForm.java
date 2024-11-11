package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Livro;

import java.time.LocalDateTime;


public class LivroForm {
    
    private String titulo;
    
    private LocalDateTime dtPublicacao;
    
    private String descricao;
    
    private Capa capa;
    
    
    public LivroForm() {
    }
    
    public LivroForm(String titulo, LocalDateTime dtPublicacao, String descricao, Capa capa) {
    }
    
    
    public LivroForm converteParaForm(Livro livro){
        return new LivroForm(livro.getTitulo(),
                livro.getDtPublicacao(),
                livro.getDescricao(),
                livro.getCapa());
    }
    
    public Livro converteParaLivro(LivroForm livroForm) {
        return new Livro(livroForm.getTitulo(),
                livroForm.getDtPublicacao(),
                livroForm.getDescricao(),
                livroForm.getCapa());
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
