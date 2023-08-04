package com.codingdojo.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		
		model.addAttribute("dojo", dojoService.allDojos());
		return "views/ninja_create.jsp";
	}
	
	@PostMapping("/ninjas/new/add")
	public String newNinja(@Valid @ModelAttribute("ninja")Ninja ninja,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojo", dojoService.allDojos());
			return "views/ninja_create.jsp";
		}
		ninjaService.createNinja(ninja);
		
		return "redirect:/"+ ninja.getDojo().getId();
	}
	
	

}
