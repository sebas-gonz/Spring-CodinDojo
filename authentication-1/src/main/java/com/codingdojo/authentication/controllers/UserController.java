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

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String registerForm(@ModelAttribute("user")User user) {
		return "views/registrationPage.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "views/login.jsp";
	}
	
	@PostMapping("/")
	public String registerUser(@Valid @ModelAttribute("user")User user,BindingResult result,HttpSession session) {
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
		if(userService.findUserByEmail(email) != null) {
			session.setAttribute("user", userService.findUserByEmail(email).getId());
			
			return "redirect:/home";
		} else {
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
