package com.codingdojo.empleados_gerentes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.empleados_gerentes.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	List<Employee> findAll();

}
