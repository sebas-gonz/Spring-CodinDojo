package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentlist.models.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {
	List <Student> findAll();
	
	List <Student> findStudentByContactIsNull();
}
