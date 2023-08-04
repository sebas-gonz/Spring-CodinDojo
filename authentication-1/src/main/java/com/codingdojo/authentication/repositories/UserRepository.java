package com.codingdojo.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.authentication.models.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	User findByEmail(String email);

}
