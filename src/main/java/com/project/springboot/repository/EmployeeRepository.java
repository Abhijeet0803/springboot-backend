package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
