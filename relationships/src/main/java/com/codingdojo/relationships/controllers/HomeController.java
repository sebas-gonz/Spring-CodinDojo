package com.codingdojo.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String personLicense(Model model) {
		model.addAttribute("allperson", personService.allPersons());
		return "views/index.jsp";
    }
	
	@GetMapping("/persons/{id}")
	public String index(@PathVariable("id")Long id,Model model) {
		model.addAttribute("person", personService.findPersonById(id));
		return "views/personlicense.jsp";
	}
	@PostMapping("/")
    public String personLicense(@RequestParam("person") Long id) {
        return "redirect:/persons/" + id;
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
		model.addAttribute("person", personService.personLicenseNull());
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
