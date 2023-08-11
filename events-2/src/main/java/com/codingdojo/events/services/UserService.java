package com.codingdojo.events.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.UserRepository;

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
	
	public User findUserById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
