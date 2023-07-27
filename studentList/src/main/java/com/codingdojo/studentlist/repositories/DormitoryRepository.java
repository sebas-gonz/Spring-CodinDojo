package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentlist.models.Dormitory; 
public interface DormitoryRepository extends CrudRepository<Dormitory, Long>{
	
	List <Dormitory> findAll();
	
	Dormitory findDormitoryById(Long id);

}
