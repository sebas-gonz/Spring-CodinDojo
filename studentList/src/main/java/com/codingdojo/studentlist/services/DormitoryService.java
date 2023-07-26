package com.codingdojo.studentlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Dormitory;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.repositories.DormitoryRepository;
import com.codingdojo.studentlist.repositories.StudentRepository;

@Service
public class DormitoryService {
	
	@Autowired
	private DormitoryRepository dormitoryRepository;
	
	@Autowired
	
	private StudentRepository studentRepository;
	
	
	public Dormitory createDormitory(Dormitory dormitory) {
		return dormitoryRepository.save(dormitory);
	}
	
	public List<Dormitory> finAll(){
		return dormitoryRepository.findAll();
	}
	
	public Dormitory findDormitoryById(Long id) {
		return dormitoryRepository.findDormitoryById(id);
	}
	
	 public void addStudent(Long dormitoryId, Long studentId) {
		 Dormitory dormitory = dormitoryRepository.findDormitoryById(dormitoryId);
		 Student student = studentRepository.findStudentById(studentId);
		 
		 dormitory.addStudent(student);
         dormitoryRepository.save(dormitory);
	 }
	
	 public void deleteStudent(Long dormitoryId, Long studentId) {
		 Dormitory dormitory = dormitoryRepository.findDormitoryById(dormitoryId);
		 
		 Student student = studentRepository.findStudentById(studentId);
		 
		 dormitory.removeStudent(student);
		 dormitoryRepository.save(dormitory);
	 }

}
