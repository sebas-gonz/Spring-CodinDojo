package com.codingdojo.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo,Long>{
	
	List <Dojo> findAll();
	
	Dojo findDojoById(Long id);
	
}
