package br.com.livraria.repository.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Editora editora;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "livro_categoria", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<Autor> autores = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "livro_lingua", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "lingua_id"))
	private List<Lingua> linguas = new ArrayList<>();

	@Column(name = "dt_publicacao")
	private LocalDateTime dtPublicacao;

	private String descricao;

	@OneToOne(fetch = FetchType.LAZY)
	private Capa capa;

	public Livro() {
	}

	public Livro(String titulo, Editora editora, LocalDateTime dtPublicacao, String descricao) {
		this.titulo = titulo;
		this.editora = editora;
		this.dtPublicacao = dtPublicacao;
		this.descricao = descricao;
	}
	
	public Livro(String titulo, LocalDateTime dtPublicacao, String descricao, Capa capa) {
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
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

	public Long getId() {
		return id;
	}

}
