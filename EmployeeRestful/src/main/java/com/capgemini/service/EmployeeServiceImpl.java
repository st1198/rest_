package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Employee;
import com.capgemini.exception.EmployeeExistsException;
import com.capgemini.exception.EmployeeNotFoundException;
import com.capgemini.repo.EmployeeRepoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepoImpl employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeExistsException {
		// find the employee
		Optional<Employee> emp = employeeRepository.findById(employee.getId());

		if (emp.isPresent()) {
			throw new EmployeeExistsException("Employee is already present");
		} else {
			Employee empSave = employeeRepository.save(employee);
			return empSave;
		}
		
	}

	@Override
	public String deleteEmployee(Employee employee) throws EmployeeNotFoundException {
		// find the employee
		Optional<Employee> emp = employeeRepository.findById(employee.getId());

		// Employee if valid then delete
		if (emp.isPresent()) {
			employeeRepository.delete(employee);
			return "Emplyoee has been removed";
		} else {
			throw new EmployeeNotFoundException("Employee is invalid");
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

}
