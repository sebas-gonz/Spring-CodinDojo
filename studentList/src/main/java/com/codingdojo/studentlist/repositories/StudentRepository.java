package com.codingdojo.studentlist.repositories;

import java.util.List;

import com.codingdojo.studentlist.models.Class;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentlist.models.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {
	List <Student> findAll();
	
	List <Student> findStudentByContactIsNull();
	
	List <Student> findStudentByDormitoryIsNull();
	
	Long findDormitoryIdById(Long id);
	
	Student findStudentById(Long id);
	
	List<Student> findByClasNotContains(Class clas);

	
	
}
