package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Inventario;
import br.com.livraria.repository.entity.Lingua;
import br.com.livraria.repository.entity.Livro;

public class InventarioDTO {

	private Long id;

	private Livro livro;

	private Lingua lingua;

	private int qtdLivros;

	public InventarioDTO() {
	}

	public InventarioDTO(Long id, Livro livro, Lingua lingua, int qtdLivros) {
		this.id = id;
		this.livro = livro;
		this.lingua = lingua;
		this.qtdLivros = qtdLivros;
	}

	public InventarioDTO converteParaDTO(Inventario inventario) {
		return new InventarioDTO(inventario.getId(), inventario.getLivro(), inventario.getLingua(),
				inventario.getQtdLivros());
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
}
