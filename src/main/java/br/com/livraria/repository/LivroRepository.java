package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

}
