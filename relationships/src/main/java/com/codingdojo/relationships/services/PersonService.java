package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired 
	 private PersonRepository personRepository;
	
	public Person createPerson(Person person) {
		
		return personRepository.save(person);
	}
	
	public List<Person> personLicenseNull(){
		return personRepository.findPersonByLicenseIsNull();
	}
	public Person findPersonById(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
}
