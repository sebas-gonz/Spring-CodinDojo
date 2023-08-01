package com.codingdojo.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo_overflow.models.Question;
import com.codingdojo.dojo_overflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public List<Question> allQuestion(){
		
		return questionRepository.findAll();
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if(optionalQuestion.isEmpty()) {
			return null;
		}
		
		return optionalQuestion.get();
	}
	
}
