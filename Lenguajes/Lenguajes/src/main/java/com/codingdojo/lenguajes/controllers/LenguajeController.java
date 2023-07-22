package com.codingdojo.lenguajes.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.validation.BindingResult;

import com.codingdojo.lenguajes.models.Lenguaje;
import com.codingdojo.lenguajes.services.LenguajeService;
import jakarta.validation.Valid;

@Controller
public class LenguajeController {

	private final LenguajeService lenguajeService;

	public LenguajeController(LenguajeService lenguajeService) {
		this.lenguajeService = lenguajeService;
	}

	@GetMapping("/lenguajes")
	public String index(Model model) {
		List<Lenguaje> lenguajes = lenguajeService.allLenguajes();
		model.addAttribute("lenguajes", lenguajes);
		model.addAttribute("lenguaje", new Lenguaje());
		return "/lenguajes/index.jsp";
	}

	@PostMapping(value = "/lenguajes")
	public String create(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/lenguajes";
		}
		lenguajeService.createLenguaje(lenguaje);
		return "redirect:/lenguajes";
	}

	@GetMapping("/lenguajes/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lenguaje lenguaje = lenguajeService.findLenguaje(id);
		model.addAttribute("showlenguaje", lenguaje);

		return "/lenguajes/show.jsp";
	}

	@DeleteMapping("/lenguajes/{id}")
	public String destroy(@PathVariable("id") Long id) {
		lenguajeService.deleteLenguaje(id);

		return "redirect:/lenguajes";
	}
	
	@GetMapping("/lenguajes/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        model.addAttribute("lenguaje", lenguaje);
        return "/lenguajes/edit.jsp";
    }
	
	@PutMapping("/lenguajes/{id}/edit")
	public String update(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult result) {
		if(result.hasErrors()) {
		      return "redirect:/books/{id}/edit.jsp";
		}
		else {
			lenguajeService.updateLenguaje(lenguaje);
			return "redirect:/lenguajes/{id}";
		}
		
		
	}
}
