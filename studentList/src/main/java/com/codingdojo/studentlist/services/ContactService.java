package com.codingdojo.studentlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Contact;
import com.codingdojo.studentlist.repositories.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public Contact getContactByStudent(Long id) {
		return contactRepository.getContactByStudentId(id);
	}
	public List<Contact> allContact(){
		return contactRepository.findAll();
	}
}
