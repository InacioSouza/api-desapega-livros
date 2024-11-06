package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

	// Uma busca de autor por nome deve devolver uma lista pois pode ter mais de um
	// autor com o mesmo nome
	List<Autor> findByNomeIgnoreCase(String nome);

	@Query("SELECT a FROM Autor a LEFT JOIN FETCH a.livros WHERE a.id = :id")
	Autor getAutorComLivros(@Param("id") Long id);

	@Query("SELECT a FROM Autor a WHERE a.nome = :nome AND a.sobrenome = :sobrenome AND a.nacionalidade = :nacionalidade")
	Autor buscaAutorPorTodosOsAtributos(@Param("nome") String nome, @Param("sobrenome") String sobrenome,
			@Param("nacionalidade") String nacionalidade);

}
