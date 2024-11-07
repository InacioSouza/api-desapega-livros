package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.repository.entity.Inventario;

@Repository
public interface InventarioRepository extends CrudRepository<Inventario, Long> {

}
