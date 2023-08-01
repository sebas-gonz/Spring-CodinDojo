package com.codingdojo.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo_overflow.models.Tag;
import com.codingdojo.dojo_overflow.repositories.TagRepository;

@Service 
public class TagService {
	
	@Autowired
 	private TagRepository tagRepository;
	
	public Tag createTag(Tag tag) {

		return tagRepository.save(tag);
	}
	
	public List<Tag> allTags(){
		return tagRepository.findAll();
	}
	
	public Tag findTagById(Long id) {
		
		Optional<Tag> optionalTag = tagRepository.findById(id);
		if(optionalTag.isEmpty()) {
			
			return null;
		}
		return optionalTag.get();
	}
	
	public Tag findBySubject(String subjetc) {
		return tagRepository.findBySubject(subjetc);
	}
}
