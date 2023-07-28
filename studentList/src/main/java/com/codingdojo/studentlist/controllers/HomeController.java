package com.codingdojo.studentlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentlist.services.DormitoryService;
import com.codingdojo.studentlist.services.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	private DormitoryService dormitoryService;
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dormitories", dormitoryService.finAll());
		model.addAttribute("students", studentService.allStudent());
		
		return "views/index.jsp";
	}
	
	@PostMapping("/")
	public String indexDormitory(@RequestParam("dormitory")Long id) {
		
		return "redirect:/dorms/"+ id;
	}
	
	@PostMapping("/students")
	public String students(@RequestParam("student")Long id) {
		
		return "redirect:/student/" + id;
	}
	

}
