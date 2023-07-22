package com.codingdojo.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lenguajes.models.Lenguaje;

@Repository
public interface LenguajeRepository extends CrudRepository<Lenguaje,Long>{
	
	List<Lenguaje> findAll();
	
	List<Lenguaje> findByCreatorContaining(String creador);
	
	void deleteById(Long id);

}
