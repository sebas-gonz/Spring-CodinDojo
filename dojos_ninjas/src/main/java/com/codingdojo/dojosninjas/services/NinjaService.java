package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	
	private NinjaRepository ninjaRepository;
	
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}

}
