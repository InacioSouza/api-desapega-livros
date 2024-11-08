package br.com.livraria.repository;

import br.com.livraria.repository.entity.Autor;
import br.com.livraria.repository.entity.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Capa;

@Repository
public interface CapaRepository extends CrudRepository<Capa, Long> {

    @Query("SELECT a FROM Capa a LEFT JOIN FETCH a.livros WHERE a.id = :id")
    Autor getCapaComLivros(@Param("id") Long id);

    @Query("SELECT a FROM Capa a WHERE a.nome = :nome AND a.tipo = :tipo AND a.categoria_id = :categoria_id")
    Capa buscaCapaPorTodosOsAtributos(@Param("nome") String nome, @Param("tipo") String tipo,
                                        @Param("categoria_id") Categoria categoria);


}
