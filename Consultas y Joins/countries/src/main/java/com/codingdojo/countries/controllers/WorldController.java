package com.codingdojo.countries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.countries.services.ApiService;

@Controller
public class WorldController {
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/1")
	public String paisesEslovenos(Model model) {
		model.addAttribute("tabla", apiService.findCountriesWithSloveneLanguage());
		
		return "views/1.jsp";
	}
	
	@GetMapping("/2")
	public String ciudadesPorPais(Model model) {
		model.addAttribute("tabla", apiService.findCitiesByCountries());
		
		return "views/2.jsp";
	}
	
	@GetMapping("/3")
	public String mayoresCiudadesDeMexico(Model model) {
		model.addAttribute("tabla", apiService.findCitiesOfMexicoByPopulation());
		
		return "views/3.jsp";
	}
	@GetMapping("/4")
	public String paisesConMayorPorcentajeDeIdioma(Model model) {
		model.addAttribute("tabla", apiService.findLanguageByPercentage());
		
		return "views/4.jsp";
	}
	@GetMapping("/5")
	public String paisesConAltaDensidad(Model model) {
		model.addAttribute("tabla", apiService.findCountriesByDensity());
		
		return "views/5.jsp";
	}
	@GetMapping("/6")
	public String paisesConMonarquia(Model model) {
		model.addAttribute("tabla", apiService.findCountriesByGobMonarchy());
		
		return "views/6.jsp";
	}
	
	@GetMapping("/7")
	public String ciudadesDentroDeBuenosAires(Model model) {
		model.addAttribute("tabla", apiService.findCitiesArg());
		
		return "views/7.jsp";
	}
	@GetMapping("/8")
	public String paisesPorRegions(Model model) {
		model.addAttribute("tabla", apiService.findCountriesByRegion());
		
		return "views/8.jsp";
	}
}
