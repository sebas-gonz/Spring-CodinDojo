package com.codingdojo.events.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.events.models.User;

public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);

	Optional<User> findById(Integer id);
}
