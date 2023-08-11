package com.codingdojo.events.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Comment;
import com.codingdojo.events.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;

	public Comment createComment(Comment comment) {
		return commentRepo.save(comment);
	}

	public Comment findComment(Long id) {
		Optional<Comment> comment = commentRepo.findById(id);
		if (comment.isPresent()) {
			return comment.get();
		} else {
			return null;
		}
	}

}
