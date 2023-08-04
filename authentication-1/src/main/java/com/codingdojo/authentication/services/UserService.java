package com.codingdojo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public User	findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
}
