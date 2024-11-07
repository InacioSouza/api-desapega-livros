package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Lingua;

@Repository
public interface LinguaRepository extends CrudRepository<Lingua, Long> {

}
