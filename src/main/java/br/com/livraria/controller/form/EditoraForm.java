package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Editora;

public class EditoraForm {

	private String nome;

	public EditoraForm() {
	}

	public EditoraForm(String nome) {
		this.nome = nome;
	}

	public Editora converteParaEditora(EditoraForm editoraForm) {
		return new Editora(editoraForm.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
