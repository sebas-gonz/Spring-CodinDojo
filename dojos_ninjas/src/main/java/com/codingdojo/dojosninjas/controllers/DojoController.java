package com.codingdojo.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	
	@GetMapping("/dojos/new")
	
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "views/new_dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			
			return "views/new_dojo.jsp";
		}
		dojoService.createDojo(dojo);
		
		return "redirect:/ninjas/new";
	}

}
