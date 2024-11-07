package br.com.livraria.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String sobrenome;

	@Column(name = "nome_artistico")
	private String nomeArtistico;
	private String nacionalidade;

	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros = new ArrayList<>();

	public Autor() {
	}

	public Autor(String nome, String sobrenome, String nomeArtistico, String nacionalidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeArtistico = nomeArtistico;
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Long getId() {
		return id;
	}

	public List<Livro> getLivro() {
		return livros;
	}

	public void setLivro(List<Livro> livro) {
		this.livros = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nomeArtistico=" + nomeArtistico
				+ ", nacionalidade=" + nacionalidade + "]";
	}

}
