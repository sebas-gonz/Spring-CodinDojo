package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify,Long> {
	
	List<Lookify> findByArtistContaining(String artist);
	
	List<Lookify> findTop10ByOrderByRatingDesc();
	
	void deleteById(Long id);
	
	List<Lookify> findAll();
}
