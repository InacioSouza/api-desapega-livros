package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Capa;

public class MetaDadosImagem {
	private String nome;
	private String tipo;
	private CategoriaForm categoria;
	private String descricao;

	public MetaDadosImagem() {

	}

	public MetaDadosImagem(String nome, String tipo, CategoriaForm categoria, String descricao) {
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public Capa adicionaDadosEmCapa(Capa capa) {

		capa.setNome(this.nome);
		capa.setTipo(this.tipo);
		
		
		capa.setCategoria(this.categoria.converteParaCategoria());
		capa.setDescricao(this.descricao);

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaForm getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaForm categoria) {
		this.categoria = categoria;
	}
	
	
}
