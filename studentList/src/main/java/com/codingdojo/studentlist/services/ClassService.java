package com.codingdojo.studentlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.repositories.ClassRepository;
@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepository;
	
	public List<Class> allClasses() {
		return classRepository.findAll();
	}
	
	public Class findClassById(Long id) {
		return classRepository.findClassById(id);
		
	}
	
	public List<Class> findStudentsNotContain(Student students){
		
		return classRepository.findByStudentsNotContains(students);
	}
	
	public Class createClass(Class clas) {
		return classRepository.save(clas);
	}
}
