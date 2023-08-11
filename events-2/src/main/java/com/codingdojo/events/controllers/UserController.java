package com.codingdojo.events.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.events.models.User;
import com.codingdojo.events.services.UserService;
import com.codingdojo.events.components.EstadosdeUsa;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EstadosdeUsa estados;
	

	@GetMapping("/")
	public String register(Model model,@ModelAttribute("user") User user,BindingResult result) {
		model.addAttribute("states", estados.getEstados());
		return "views/register.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,BindingResult result,HttpSession session,Model model) {
		    if (result.hasErrors()) {
		        model.addAttribute("states", estados.getEstados());
		        return "views/register.jsp";
		    }
		    userService.registerUser(user);
		    session.setAttribute("userId", user.getId());
		    return "redirect:/events";
		}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email,@RequestParam("password") String password,Model model,
			@ModelAttribute("user") User user) {
		boolean authenticated = userService.authenticateUser(email, password);
		if (authenticated) {
			session.setAttribute("userId", userService.findUserByEmail(email).getId());
			return "redirect:/events";
		} else {
			model.addAttribute("error", "La cuenta no existe");
			model.addAttribute("states", estados.getEstados());
			return "views/register.jsp";
		}
	}

}
