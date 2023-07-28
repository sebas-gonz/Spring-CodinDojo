package com.codingdojo.studentlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.services.ClassService;

import jakarta.validation.Valid;

@Controller
public class ClassController {
	
	
	@Autowired
	
	private ClassService classService;
	

	
	@GetMapping("/classes/new")
	public String newClass(@ModelAttribute("class") Class clas) {
		
		return "views/new_class.jsp";
		
	}
	
	@PostMapping("/classes/new")
	public String createClass(@Valid @ModelAttribute("class")Class clas,BindingResult result) {
		if(result.hasErrors()) {
			return "views/new_class.jsp";
		}
		classService.createClass(clas);
		
		return "redirect:/classes/new";
	}
	
	@GetMapping("/classes/{id}")
	public String clas(@PathVariable("id")Long id,Model model,
			@ModelAttribute("class") Class clas) {
		model.addAttribute("class", classService.findClassById(id));
		
		return "views/classes_students.jsp";
	}
	

}
