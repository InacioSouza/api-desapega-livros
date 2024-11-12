package br.com.livraria.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.livraria.repository.entity.Autor;
import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Livro;

public class LivroDTO {

	private Long id;

	private List<Autor> autores;

	private String titulo;

	private LocalDateTime dtPublicacao;

	private String descricao;

	private Capa capa;

	public LivroDTO() {
	}

	public LivroDTO(Long id, List<Autor> autores, String titulo, LocalDateTime dtPublicacao, String descricao,
			Capa capa) {
		this.id = id;
		this.autores = autores;
		this.titulo = titulo;
		this.dtPublicacao = dtPublicacao;
		this.descricao = descricao;
		this.capa = capa;
	}

	public LivroDTO converteParaDTO(Livro livro) {
		return new LivroDTO(livro.getId(), livro.getAutores(), livro.getTitulo(), livro.getDtPublicacao(),
				livro.getDescricao(), livro.getCapa());
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
