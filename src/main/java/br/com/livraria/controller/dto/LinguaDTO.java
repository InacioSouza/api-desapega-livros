package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Lingua;

public class LinguaDTO {

	private Long id;

	private String nome;

	public LinguaDTO() {
	}

	public LinguaDTO(Long id, String nome) {
		this.nome = nome;
	}

	public LinguaDTO converteParaDTO(Lingua lingua) {
		return new LinguaDTO(lingua.getId(), lingua.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
