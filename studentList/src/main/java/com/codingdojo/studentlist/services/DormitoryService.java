package com.codingdojo.studentlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Dormitory;
import com.codingdojo.studentlist.repositories.DormitoryRepository;

@Service
public class DormitoryService {
	
	@Autowired
	private DormitoryRepository dormitoryRepository;
	
	
	public Dormitory createDormitory(Dormitory dormitory) {
		return dormitoryRepository.save(dormitory);
	}
	
	public List<Dormitory> finAll(){
		return dormitoryRepository.findAll();
	}
	
	public Dormitory findDormitoryById(Long id) {
		return dormitoryRepository.findDormitoryById(id);
	}
	
	

}
