package com.codingdojo.events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.events.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
