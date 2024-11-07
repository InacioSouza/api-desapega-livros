package br.com.livraria.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.livraria.repository.entity.Autor;

public class AutorDTO {

	private String nome;

	private String sobrenome;

	private String nomeArtistico;

	private String nacionalidade;

	public AutorDTO() {

	}

	public AutorDTO(String nome, String sobrenome, String nomeArtistico, String nacionalidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeArtistico = nomeArtistico;
		this.nacionalidade = nacionalidade;
	}

	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.sobrenome = autor.getSobrenome();
		this.nomeArtistico = autor.getNomeArtistico();
		this.nacionalidade = autor.getNacionalidade();
	}

	public Autor converteParaAutor() {
		return new Autor(this.nome, this.sobrenome, this.nomeArtistico, this.nacionalidade);
	}

	public List<AutorDTO> converteParaAutorDTO(List<Autor> autores) {

		return autores.stream().map(AutorDTO::new).collect(Collectors.toList());

	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	@Override
	public String toString() {
		return "AutorDTO [nome=" + nome + ", sobrenome=" + sobrenome + ", nomeArtistico=" + nomeArtistico
				+ ", nacionalidade=" + nacionalidade + "]";
	}



}
