package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private final LookifyRepository lookifyRepository;

	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public Lookify createSong(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	
	public List<Lookify> topSongs(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Lookify findSongById(Long id) {
		Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
		if (optionalLookify.isPresent()) {
			return optionalLookify.get();
		} else {
			return null;
		}
	}
	
	public void deleteTrack(Long id) {
		if (lookifyRepository.existsById(id)) {
			lookifyRepository.deleteById(id);
		} else {
			return;
		}
	}
	
	public List<Lookify> allTracks(){
		return lookifyRepository.findAll();
	}
	
	public List<Lookify> findSongByArtist(String artist){
		return lookifyRepository.findByArtistContaining(artist);
	}
}
