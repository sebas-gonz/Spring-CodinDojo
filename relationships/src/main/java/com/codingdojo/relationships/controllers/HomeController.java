package com.codingdojo.relationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private PersonService personService;

	@Autowired
	private LicenseService licenseService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("allperson", persons);
		return "views/index.jsp";
	}
	@PostMapping("/")
	public String personLicense(@RequestParam("person")Long id, Model model){
		Person persona = personService.findPersonById(id);
		model.addAttribute("person", persona);
		License licencia = licenseService.getLicenseByPersonById(id);
		model.addAttribute("license", licencia);

		return "views/personlicense.jsp";
	}
	

	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {

		return "/views/newperson.jsp";
	}

	@PostMapping("/persons")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "views/newperson.jsp";
		}
		personService.createPerson(person);

		return "redirect:/licenses/new";

	}

	@GetMapping("licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> personsNoLicense = personService.personLicenseNull();
		model.addAttribute("person", personsNoLicense);
		return "views/newlicense.jsp";
	}

	@PostMapping("/licenses")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {


		if (result.hasErrors()) {
			return "views/newlicense.jsp";
		}


			String licenseNumber = String.format("%06d", license.getPerson().getId());

			license.setNumber(licenseNumber);

			licenseService.createLicense(license);


			return "redirect:/";

	}
	

	

}
