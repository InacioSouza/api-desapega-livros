package br.com.livraria.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "capa")
public class Capa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo;
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Categoria categoria;
	private String descricao;
	private byte[] imagem;

	public Capa() {
	}

	public Capa(String nome, String tipo, String descricao, Categoria categoria) {
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public Capa(String nome, String tipo, Categoria categoria, String descricao, byte[] imagem) {
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

	public Long getId() {
		return id;
	}
	
}
