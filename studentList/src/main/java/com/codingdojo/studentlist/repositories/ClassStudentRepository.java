package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentlist.models.ClassStudent;

public interface ClassStudentRepository extends CrudRepository<ClassStudent, Long>{
	
	List<ClassStudent> findAll();
	
	ClassStudent findClassStudentById(Long id);
	
	ClassStudent getClassStudentByClasId(Long id);
	
	ClassStudent getClassStudentByStudentId(Long id);

}
