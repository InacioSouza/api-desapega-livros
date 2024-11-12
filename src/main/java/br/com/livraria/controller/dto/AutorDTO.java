package br.com.livraria.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.livraria.repository.entity.Autor;

public class AutorDTO {

	@JsonProperty("id")
	private Long id;

	private String nome;

	private String sobrenome;

	private String nomeArtistico;

	private String nacionalidade;

	public AutorDTO() {

	}

	public AutorDTO(Long id, String nome, String sobrenome, String nomeArtistico, String nacionalidade) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeArtistico = nomeArtistico;
		this.nacionalidade = nacionalidade;
	}

	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.sobrenome = autor.getSobrenome();
		this.nomeArtistico = autor.getNomeArtistico();
		this.nacionalidade = autor.getNacionalidade();
	}

	public void setValuesAutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.sobrenome = autor.getSobrenome();
		this.nomeArtistico = autor.getNomeArtistico();
		this.nacionalidade = autor.getNacionalidade();
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
		return "AutorDTO [ id=" + id + "nome=" + nome + ", sobrenome=" + sobrenome + ", nomeArtistico=" + nomeArtistico
				+ ", nacionalidade=" + nacionalidade + "]";
	}

	public List<AutorDTO> converteParaAutorDTO(List<Autor> autores) {

		return autores.stream().map(AutorDTO::new).collect(Collectors.toList());

	}

}
