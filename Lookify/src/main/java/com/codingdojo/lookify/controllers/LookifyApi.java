package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;

@RestController
public class LookifyApi {
	
	private final LookifyService lookifyService;

	public LookifyApi(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@GetMapping("api/songs")
	public List<Lookify> index() {
		return lookifyService.allTracks();
	}
}
