package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
