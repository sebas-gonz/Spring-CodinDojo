package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentlist.models.Contact;

public interface ContactRepository extends CrudRepository<Contact,Long>{
	
	
	Contact getContactByStudentId(Long id);
	
	List <Contact> findAll();

}
