package br.com.livraria.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.livraria.repository.entity.Categoria;

public class CategoriaDTO {

	private Long id;

	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public CategoriaDTO converteParaDTO(Categoria categoria) {
		return new CategoriaDTO(categoria.getId(), categoria.getNome());
	}

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CategoriaDTO> converteParaCategoriaDTO(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
	}

}
