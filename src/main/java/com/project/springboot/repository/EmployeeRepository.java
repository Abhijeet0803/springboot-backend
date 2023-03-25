package com.project.springboot.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import com.project.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


	
}
