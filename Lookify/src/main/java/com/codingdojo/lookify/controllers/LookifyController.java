package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;

import jakarta.validation.Valid;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		
		this.lookifyService = lookifyService;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "/tracklist/index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dash(Model model) {
		List<Lookify> tracklist = lookifyService.allTracks();
		
		model.addAttribute("tracklist", tracklist);
		
		return("/tracklist/dashboard.jsp");
	}
	
	@GetMapping("/songs/{id}")
	public String song(@PathVariable("id") Long id, Model model) {
		Lookify song = lookifyService.findSongById(id);
		model.addAttribute("song", song);
		
		return "/tracklist/song.jsp";
	}
	
	@PostMapping("/dashboard")
	public String search(@RequestParam("artist")String artist,Model model) {
		List<Lookify> songs = lookifyService.findSongByArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		
		return "/tracklist/search.jsp";		
		
	}
	
	@GetMapping("/search/topten")
	
	public String topTen(Model model) {
		List<Lookify> topten = lookifyService.topSongs();
		
		model.addAttribute("topten",topten);
		
		return "/tracklist/top.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Lookify song) {
		
		return "tracklist/new.jsp";
	}
	@PostMapping(value = "/songs")
	public String create(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
		if (result.hasErrors()) {
			return "tracklist/new.jsp";
		}
		lookifyService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/dashboard/{id}")
	public String destroy(@PathVariable("id") Long id) {
		lookifyService.deleteTrack(id);

		return "redirect:/dashboard";
	}
	
	
	
}
