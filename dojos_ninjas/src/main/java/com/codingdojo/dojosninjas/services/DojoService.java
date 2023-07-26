package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired

	private DojoRepository dojoRepository;

	public Dojo createDojo(Dojo dojo) {

		return dojoRepository.save(dojo);
	}
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo findDojoById(Long id){
		
		return dojoRepository.findDojoById(id);
	}
}
