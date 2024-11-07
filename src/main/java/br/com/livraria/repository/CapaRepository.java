package br.com.livraria.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Autor;
import br.com.livraria.repository.entity.Capa;
import br.com.livraria.repository.entity.Categoria;

@Repository
public interface CapaRepository extends CrudRepository<Capa, Long> {

	@Query("SELECT cp FROM Capa cp WHERE cp.nome = :nome AND cp.tipo = :tipo AND cp.categoria = :categoria AND cp.imagem = :imagem")
	Capa buscaCapaPorTodosOsAtributos(@Param("nome") String nome, @Param("tipo") String tipo,
			@Param("categoria") Categoria categoria, @Param("imagem") byte[] imagem);

}
