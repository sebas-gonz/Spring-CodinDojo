package com.codingdojo.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo_overflow.models.TagQuestion;
import com.codingdojo.dojo_overflow.repositories.TagQuestionRepository;

@Service
public class TagQuestionService {
		
	@Autowired
	private TagQuestionRepository tagQuestionRepository;
	
	public List<TagQuestion> findAll(){
		
		return tagQuestionRepository.findAll();
	}
	
	public TagQuestion findById(Long id) {
		Optional<TagQuestion> optionalTagQuestion = tagQuestionRepository.findById(id);
		if(optionalTagQuestion.isEmpty()) {
			return null;
		}
		return optionalTagQuestion.get();
	}
	
	public TagQuestion createTagQuestion(TagQuestion tagQuestion) {
		
		return tagQuestionRepository.save(tagQuestion);
	}
	
}
