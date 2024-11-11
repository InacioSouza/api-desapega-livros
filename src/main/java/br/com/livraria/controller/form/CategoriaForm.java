package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Categoria;

public class CategoriaForm {
	private String nome;
	
	public CategoriaForm() {
		
	}
	
	public CategoriaForm(String nome) {
		this.nome = nome;
	}

	public Categoria converteParaCategoria() {
		return new Categoria(this.nome);
	}
	
	public  CategoriaForm converteParaCategoriaForm(Categoria categoria){
		return new CategoriaForm(categoria.getNome());
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
