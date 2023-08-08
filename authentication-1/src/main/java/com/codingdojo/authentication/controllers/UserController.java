package com.codingdojo.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;
import com.codingdojo.authentication.validations.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String registerForm(@ModelAttribute("user")User user) {
		return "views/registrationPage.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "views/login.jsp";
	}
	
	@PostMapping("/")
	public String registerUser(Model model,@Valid @ModelAttribute("user")User user,BindingResult result,HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "views/registrationPage.jsp";
		}else {
			userService.registerUser(user);
			session.setAttribute("user", user.getId());
			return "redirect:/login";
		}
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("email")String email,@RequestParam("password")String password,Model model,HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated ) {
			session.setAttribute("userId", userService.findUserByEmail(email).getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Sesion invalida reintentelo denuevo");
			return "views/login.jsp";
		}
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user");
			  model.addAttribute("loginUser", userService.findUserById(userId));
			  return "views/home.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	
	
}
