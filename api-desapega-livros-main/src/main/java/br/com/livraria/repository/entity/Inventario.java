package br.com.livraria.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventario")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Livro livro;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Lingua lingua;
	
	@Column(name="qtd_livro")
	private int qtdLivros;
	
	public Inventario(){}

	public Inventario(Livro livro, int qtdLivros) {
		super();
		this.livro = livro;
		this.qtdLivros = qtdLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
