package com.codingdojo.studentlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.ClassStudent;
import com.codingdojo.studentlist.repositories.ClassStudentRepository;

@Service
public class ClassStudentService {

	@Autowired
	private ClassStudentRepository classStudentRepository;

	public ClassStudent createClassStudent(ClassStudent classStudent) {

		return classStudentRepository.save(classStudent);
	}

	public ClassStudent findClassStudent(Long id) {

		Optional<ClassStudent> classStudent = classStudentRepository.findById(id);
		if (classStudent.isEmpty()) {
			return null;
		} else {
			return classStudent.get();
		}
	}
	
	public List<ClassStudent> allClassStudent(){
		return classStudentRepository.findAll();
	}
	
	public ClassStudent getClassStudentByStudent(Long id) {
		return classStudentRepository.getClassStudentByStudentId(id);
	}
	public ClassStudent getClassStudentByClass(Long id) {
		return classStudentRepository.getClassStudentByClasId(id);
	}
}
