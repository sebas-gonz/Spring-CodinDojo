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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.models.ClassStudent;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.services.ClassService;
import com.codingdojo.studentlist.services.ClassStudentService;
import com.codingdojo.studentlist.services.StudentService;

import jakarta.validation.Valid;
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private ClassStudentService classStudentService;
	


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
		Student student = studentService.findStudentById(id);
		
		student.setDormitory(null);
		
		studentService.createStudent(student);

		return "redirect:/dorms/"+ dormitoryId;
	}
	
	@GetMapping("/student/{id}")
	public String student(@PathVariable("id")Long id,Model model,@ModelAttribute("class_student")ClassStudent classStudent){
		model.addAttribute("student", studentService.findStudentById(id));
		model.addAttribute("clase", classService.findStudentsNotContain(studentService.findStudentById(id)));
		
		return "views/students_classes.jsp";
	}
	
	@PostMapping("/student/{studentId}/add")
	public String addClass(@PathVariable("studentId")Long studentId,@RequestParam(name = "class", required = false)Long id,
			@ModelAttribute("class_student")ClassStudent classStudent) {
		if(id == null) {
			return "redirect:/student/"+studentId;
		}
		
		Student student = studentService.findStudentById(studentId);
		Class clas = classService.findClassById(id);
		
		classStudent.setStudent(student);
		classStudent.setClas(clas);
		
		classStudentService.createClassStudent(classStudent);
		
		return "redirect:/student/" + student.getId();
		
	}
	
	@DeleteMapping ("/student/{studentId}/{classId}/class")
	public String destroyClass(@PathVariable("studentId")Long studentId,@PathVariable("classId")Long id,
			@ModelAttribute("class")Class clas) {
		if (id == null) {
	        return "redirect:/products/" + studentId;
	    }

			
			ClassStudent classStudent = classStudentService.getClassStudentByClass(id);
			classStudent.setClas(null);
			
			classStudentService.createClassStudent(classStudent);
			
			return "redirect:/student/" + studentId;
			
	}
	
}
