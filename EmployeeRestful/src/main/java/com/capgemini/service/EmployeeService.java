package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Employee;
import com.capgemini.exception.EmployeeExistsException;
import com.capgemini.exception.EmployeeNotFoundException;

public interface EmployeeService {

	public abstract Employee createEmployee(Employee employee) throws EmployeeExistsException;

	public abstract String deleteEmployee(Employee employee) throws EmployeeNotFoundException;

	public abstract List<Employee> getAllEmployees();

}
