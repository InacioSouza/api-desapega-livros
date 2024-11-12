package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Categoria;

public class CapaDTO {
	
	private Long id;

	private String nome;

	private String tipo;

	private Categoria categoria;

	private String descricao;

	private byte[] imagem;

	public CapaDTO() {
	}

	public CapaDTO(String nome, String tipo, Categoria categoria, String descricao, byte[] imagem) {
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public CapaDTO(Capa capa) {
		this.id = capa.getId();
		this.nome = capa.getNome();
		this.tipo = capa.getTipo();
		this.categoria = capa.getCategoria();
		this.descricao = capa.getDescricao();
		this.imagem = capa.getImagem();
	}

	public CapaDTO converteParaDTO(Capa capa) {
		return new CapaDTO(capa);
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
