package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Capa;

public class CapaForm {

	private String nome;
	private String tipo;
	private CategoriaForm categoria;
	private String descricao;
	private byte[] imagem;

	public CapaForm() {
	}

	public CapaForm(String nome, String tipo, CategoriaForm categoriaForm, String descricao, byte[] imagem) {
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoriaForm;
		this.descricao = descricao;
		this.imagem = imagem;
	}
	
	public CapaForm(Capa capa) {
	
	}

	public Capa converteParaCapa() {
		Capa capa = new Capa(this.nome, this.tipo, this.descricao, this.categoria.converteParaCategoria(),
				this.imagem);

		return capa;
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

	public CategoriaForm getCategoriaForm() {
		return categoria;
	}

	public void setCategoriaForm(CategoriaForm categoriaForm) {
		this.categoria = categoriaForm;
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
