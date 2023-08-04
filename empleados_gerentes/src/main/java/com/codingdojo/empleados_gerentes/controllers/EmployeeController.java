package com.codingdojo.empleados_gerentes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.empleados_gerentes.models.Employee;
import com.codingdojo.empleados_gerentes.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	public void employees(@PathVariable("id")Long id) {
		
		System.out.println(employeeService.findEmployeeById(id).getManager().getFirst_name());
		
		for(Employee empleado : employeeService.findEmployeeById(id).getEmployee()) {
			System.out.println(empleado.getFirst_name());
		}
		
		
	}

}
