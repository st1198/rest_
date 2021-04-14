package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.exception.EmployeeExistsException;
import com.capgemini.exception.EmployeeNotFoundException;
import com.capgemini.service.EmployeeService;

@RestController
public class EmployeeController {

	// Service
	@Autowired
	private EmployeeService employeeSerivce;

	@PostMapping(path = "/employee")
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeExistsException {
		Employee emp = employeeSerivce.createEmployee(employee);
		return emp;
	}

	@DeleteMapping(path = "/employee")
	public String removeEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return employeeSerivce.deleteEmployee(employee);
	}

	@GetMapping(path = "/employee")
	public List<Employee> getAllEmployee() {
		return employeeSerivce.getAllEmployees();
	}

}
