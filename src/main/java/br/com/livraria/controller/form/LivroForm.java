package br.com.livraria.controller.form;

import java.time.LocalDateTime;
import java.util.List;

import br.com.livraria.repository.entity.Autor;
import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Editora;
import br.com.livraria.repository.entity.Livro;

public class LivroForm {

	private String titulo;

	private LocalDateTime dtPublicacao;

	private Editora editora;

	private List<Autor> autores;

	private String descricao;

	private Capa capa;

	public LivroForm() {
	}

	public LivroForm(String titulo, Editora editora, LocalDateTime dtPublicacao, String descricao, Capa capa,
			List<Autor> autores) {
		this.titulo = titulo;
		this.editora = editora;
		this.dtPublicacao = dtPublicacao;
		this.descricao = descricao;
		this.capa = capa;
		this.autores = autores;
	}

	public Livro converteParaLivro(LivroForm livroForm) {
		return new Livro(livroForm.getTitulo(), livroForm.getEditora(), livroForm.getDtPublicacao(),
				livroForm.getDescricao(), livroForm.getCapa(), livroForm.getAutores());
	}

	private Editora getEditora() {
		return this.editora;
	}

	private List<Autor> getAutores() {
		return this.autores;
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
