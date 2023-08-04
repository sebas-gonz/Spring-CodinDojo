package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;
import com.codingdojo.dojosninjas.repositories.Dojos_NinjasRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	@Autowired
	private Dojos_NinjasRepository dojos_ninjasRepo;

	public Dojo createDojo(Dojo dojo) {

		return dojoRepository.save(dojo);
	}
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo findDojoById(Long id){
		
		return dojoRepository.findDojoById(id);
	}
	
	public Page<Dojo> dojosNinja(int pageNumber) {
        PageRequest pageable = PageRequest.of(pageNumber,1 , Sort.by(Sort.Direction.ASC, "name"));
        return dojos_ninjasRepo.findAll(pageable);
    }
	
	public Page<Dojo> findAll(PageRequest allElements) {
		return null;
	}
}
