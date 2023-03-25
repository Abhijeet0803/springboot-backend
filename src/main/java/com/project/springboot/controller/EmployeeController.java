package com.project.springboot.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.model.Employee;
import com.project.springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(@RequestParam(name="page", required=false, defaultValue = "0") int pageNo){
		
		Pageable p = PageRequest.of(pageNo, 5);
		
		List<Employee> emp = new ArrayList<>();
		Page<Employee> page = employeeRepository.findAll(p);
		emp = page.getContent();
//		System.out.println(emp);
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return this.employeeRepository.save(emp);
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") long id) {
		return this.employeeRepository.findById(id);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		return this.employeeRepository.save(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		this.employeeRepository.deleteById(id);
	}
}
