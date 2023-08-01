package com.codingdojo.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojo_overflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	List<Answer> findAll();


}
