package com.codingdojo.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lenguajes.models.Lenguaje;
import com.codingdojo.lenguajes.repositories.LenguajeRepository;

@Service
public class LenguajeService {
	private final LenguajeRepository lenguajeRepository;

	public LenguajeService(LenguajeRepository lenguajeRepository) {
		this.lenguajeRepository = lenguajeRepository;
	}

	public Lenguaje createLenguaje(Lenguaje lenguaje) {
		return lenguajeRepository.save(lenguaje);
	}

	public List<Lenguaje> allLenguajes() {
		return lenguajeRepository.findAll();
	}

	public Lenguaje findLenguaje(Long id) {
		Optional<Lenguaje> optionalBook = lenguajeRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	public Lenguaje updateLenguaje(Long id, String name, String creator, String version) {
    
    	Optional<Lenguaje> updateLenguaje = lenguajeRepository.findById(id);
    	if(updateLenguaje.isPresent()) {
  
    		updateLenguaje.get().setName(name);
    		updateLenguaje.get().setCreator(creator);
    		updateLenguaje.get().setCurrentVersion(version);
    		
    		 return lenguajeRepository.save(updateLenguaje.get());
    	}
    	else {
    		return null;
    	}
	}
	
	public Lenguaje updateLenguaje(Lenguaje lenguaje) {
			
    		 return lenguajeRepository.save(lenguaje);
    	}
	
    	
	public void deleteLenguaje(Long id) {
		if (lenguajeRepository.existsById(id)) {
			lenguajeRepository.deleteById(id);
		} else {
			return;
		}
	}

}
