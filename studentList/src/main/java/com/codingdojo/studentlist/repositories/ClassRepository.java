package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.models.Student;
@Repository
public interface ClassRepository extends CrudRepository<Class,Long>{
	
	List<Class> findAll();
	
	List<Class> findByStudentsNotContains(Student student);

	Class findClassById(Long id);
}
