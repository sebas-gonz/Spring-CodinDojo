package com.codingdojo.studentlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.studentlist.models.Contact;
import com.codingdojo.studentlist.services.ContactService;
import com.codingdojo.studentlist.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class ContactController {
	
	
	@Autowired
	
	private ContactService contactService;
	
	@Autowired
	
	private StudentService studentService;
	
	@GetMapping("/contact/new")
	public String newContact(@ModelAttribute("contact")Contact contact,Model model) {
		model.addAttribute("student", studentService.studentContactNull());
		
		return "views/new_contact.jsp";
	}
	
	@PostMapping("/contact")
	public String createContact(@Valid @ModelAttribute("contact")Contact contact,BindingResult result) {
		if(result.hasErrors()) {
			return "views/new_contact.jsp";
		}
		contactService.createContact(contact);
		
		return "redirect:/student";
	}
}
