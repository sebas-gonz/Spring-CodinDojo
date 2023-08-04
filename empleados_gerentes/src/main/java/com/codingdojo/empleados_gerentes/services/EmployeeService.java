package com.codingdojo.empleados_gerentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.empleados_gerentes.models.Employee;
import com.codingdojo.empleados_gerentes.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> allEmployee(){
		
		return employeeRepo.findAll();
	}
	
	public Employee findEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}	
	}
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

}
