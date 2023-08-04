package com.codingdojo.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

@Controller
public class HomeController {
	
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	
	@GetMapping("/{pageNumber}")
	public String index(Model model,@PathVariable("pageNumber")int pageNumber) {
		Page<Dojo> dojosPage = dojoService.dojosNinja(pageNumber - 1);
		
		model.addAttribute("dojos", dojoService.allDojos());
		model.addAttribute("dojosninjas", dojosPage);
		
		return "views/index.jsp";
	}

	@PostMapping("/")	
	public String index(@RequestParam("dojos") Long id) {
		
		return "redirect:/dojos/" + id; 
	}
	
	@GetMapping("/dojos/{id}")
	public String dojos(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo_ninjas", dojoService.findDojoById(id));
		
		return "views/dojo_ninjas.jsp";
	}
	
	

}
