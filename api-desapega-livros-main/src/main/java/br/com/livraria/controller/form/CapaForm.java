package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Categoria;

public class CapaForm {

    private Long id;

    private String nome;

    private String tipo;

    private Categoria categoria;

    private String descricao;

    private byte[] imagem;

    public CapaForm() {
    }

    public CapaForm(Long id, String nome, String tipo, Categoria categoria, String descricao, byte[] imagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public CapaForm(Capa capa) {
        this.nome = capa.getNome();
        this.tipo = capa.getTipo();
        this.categoria = capa.getCategoria();
        this.descricao = capa.getDescricao();
        this.imagem = capa.getImagem();
    }

    public Capa converteParaCapa(CapaForm capaForm) {
        return new Capa(
                capaForm.getNome(),
                capaForm.getTipo(),
                capaForm.getDescricao(),
                capaForm.getCategoria()
        );
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
