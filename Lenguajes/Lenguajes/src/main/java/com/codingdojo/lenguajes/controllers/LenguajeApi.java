package com.codingdojo.lenguajes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.lenguajes.models.Lenguaje;
import com.codingdojo.lenguajes.services.LenguajeService;

@RestController
public class LenguajeApi {
	private final LenguajeService lenguajeService;

	public LenguajeApi(LenguajeService lenguajeService) {
		this.lenguajeService = lenguajeService;
	}

	@GetMapping("api/lenguajes")
	public List<Lenguaje> index() {
		return lenguajeService.allLenguajes();
	}

	@PostMapping(value = "/api/lenguajes")
	public Lenguaje create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator,
			@RequestParam(value = "currentVersion") String version) {
		Lenguaje lenguaje = new Lenguaje(name, creator, version);
		return lenguajeService.createLenguaje(lenguaje);
	}

	@GetMapping("/api/lenguajes/{id}")
	public Lenguaje show(@PathVariable("id") Long id) {
		return lenguajeService.findLenguaje(id);
	}

	@PutMapping(value = "/api/lenguajes/{id}")
	public Lenguaje update(Long id, String name, String creator, String version) {
		return lenguajeService.updateLenguaje(id, name, creator, version);
	}

	@DeleteMapping(value = "/api/lenguajes/{id}")
	public void destroy(@PathVariable("id") Long id) {
		lenguajeService.deleteLenguaje(id);
	}
}
