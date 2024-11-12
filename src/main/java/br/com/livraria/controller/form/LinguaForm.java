package br.com.livraria.controller.form;

import br.com.livraria.repository.entity.Lingua;

public class LinguaForm {

	private String nome;

	public LinguaForm() {
	}

	public LinguaForm(String nome) {
		this.nome = nome;
	}

	public Lingua converteParaLingua(LinguaForm linguaForm) {
		return new Lingua(linguaForm.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
