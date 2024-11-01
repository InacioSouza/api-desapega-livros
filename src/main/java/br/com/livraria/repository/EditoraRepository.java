package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Editora;

@Repository
public interface EditoraRepository extends CrudRepository<Editora, Long> {
	Editora findByNome(String nome);
}
