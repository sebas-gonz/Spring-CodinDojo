package com.codingdojo.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo_overflow.models.Answer;
import com.codingdojo.dojo_overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	
	public Answer createAnswer(Answer answer) {
		
		return answerRepository.save(answer);
	}
	
	public List<Answer> allAnswers(){
		
		return answerRepository.findAll();
	}
	
	public Answer findAnswerById(Long id) {
		Optional<Answer> optionalAnswer = answerRepository.findById(id);
		if(optionalAnswer.isEmpty()) {
			return null;
		}
		return optionalAnswer.get();
	}
}

