package com.codingdojo.studentlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.services.DormitoryService;
import com.codingdojo.studentlist.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DormitoryService dormitoryService;


	@GetMapping("/student/new")
	public String newStudent(@ModelAttribute("student") Student student) {

		return "views/new_student.jsp";
	}

	@PostMapping("/student")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "views/new_student.jsp";
		}
		studentService.createStudent(student);

		return "redirect:/contact/new";

	}
	
	@GetMapping("/student")
	public String students(Model model) {
		model.addAttribute("student" ,studentService.allStudent());
		
		return "views/student.jsp";
	}
	
	@DeleteMapping("/student/{dormitoryId}/{id}")
	public String destroy(@PathVariable("dormitoryId") Long dormitoryId,@PathVariable("id")Long id) {
		dormitoryService.deleteStudent(dormitoryId, id);

		return "redirect:/dorms/"+ dormitoryId;
	}

	
}
