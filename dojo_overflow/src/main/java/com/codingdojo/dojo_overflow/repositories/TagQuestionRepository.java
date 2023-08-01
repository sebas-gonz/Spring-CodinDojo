package com.codingdojo.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojo_overflow.models.TagQuestion;

public interface TagQuestionRepository extends CrudRepository<TagQuestion, Long> {

	List<TagQuestion> findAll();


}
