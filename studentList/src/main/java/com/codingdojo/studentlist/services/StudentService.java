package com.codingdojo.studentlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	public List<Student> studentContactNull(){
		
		return studentRepository.findStudentByContactIsNull();
	}
	
	public List<Student> allStudent(){
		return studentRepository.findAll();
	}
	

}
