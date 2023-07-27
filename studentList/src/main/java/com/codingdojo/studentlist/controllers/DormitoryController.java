package com.codingdojo.studentlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentlist.models.Dormitory;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.services.DormitoryService;
import com.codingdojo.studentlist.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormitoryController {

	@Autowired
	private DormitoryService dormitoryService;

	@Autowired

	private StudentService studentService;

	@GetMapping("/dorms/new")
	public String createDormitory(@ModelAttribute("dormitory") Dormitory dormitory) {

		return "views/new_dormitory.jsp";
	}

	@PostMapping("/dorms/new")
	public String newDormitory(@Valid @ModelAttribute("dormitory") Dormitory dormitory, BindingResult result) {
		if (result.hasErrors()) {
			return "views/new_dormitory.jsp";
		}

		dormitoryService.createDormitory(dormitory);
		return "redirect:/";
	}

	@GetMapping("/dorms/{id}")
	public String dormitory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dormitory", dormitoryService.findDormitoryById(id));
		model.addAttribute("students", studentService.studentsDormitoryNull());

		return "views/students_dormitory.jsp";
	}

	@PostMapping("/dorms/{dormitoryId}/add")

	public String addStudent(@PathVariable("dormitoryId") Long dormitoryId, @RequestParam("student") Long id) {

		Student student = studentService.findStudentById(id);
		Dormitory dormitory = dormitoryService.findDormitoryById(dormitoryId);
		
		student.setDormitory(dormitory);
		
		studentService.createStudent(student);

		return "redirect:/dorms/" + dormitory.getId();
	}
}
