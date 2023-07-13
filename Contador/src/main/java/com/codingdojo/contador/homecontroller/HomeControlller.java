package com.codingdojo.contador.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeControlller {
		
			
	@RequestMapping("/")
	public String welcome(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		int count = (int) session.getAttribute("count");
		count = count + 1;
		session.setAttribute("count", count);
		return "welcome.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session,Model model) {
		
		int contador = (int) session.getAttribute("count");
		model.addAttribute("contador", contador);
		
		
		return "count.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session,Model model) {
		int count = (int) session.getAttribute("count");
		
		count = count + 2;
		session.setAttribute("count", count);
		model.addAttribute("contador",count);
		
		return "reset.jsp";
	}
	@RequestMapping("/reinicio")
	public String reinicio(HttpSession session,Model model) {
		session.setAttribute("count", 0);
		model.addAttribute("contador",0);
		
		return "reset.jsp";
	}
}
