package com.codingdojo.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojo_overflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question,Long>{
	
	List<Question> findAll();
	

}
