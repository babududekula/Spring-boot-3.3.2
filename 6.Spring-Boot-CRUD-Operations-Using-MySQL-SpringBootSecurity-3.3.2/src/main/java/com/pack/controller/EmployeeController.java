package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Employee;
import com.pack.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/welcome")
	public String welcome()
	{
		String str = "Welcome To Spring Boot CRUD Operations";
		return str;
	}
	
	@PostMapping(value = "/add" ,
				consumes = {"application/json","application/xml"},
				produces = {"application/json","application/xml"}
				)
	public ResponseEntity<String> addData(@RequestBody Employee employee)
	{
		String addDataOrUpdateData = service.addDataOrUpdateData(employee);
		return new ResponseEntity<String>(addDataOrUpdateData, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
	public ResponseEntity<Employee> getDataById(@PathVariable Integer id)
	{
		Employee employeeById = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateData(@RequestBody Employee employee)
	{
		String addDataOrUpdateData = service.addDataOrUpdateData(employee);
		return new ResponseEntity<String>(addDataOrUpdateData, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll")
	@PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN' , 'ROLE_USER')")
	public ResponseEntity<List<Employee>> findAll()
	{
		List<Employee> list = service.getAll();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		String deleteEmployee = service.deleteEmployee(id);
		return new ResponseEntity<String>(deleteEmployee, HttpStatus.OK);
	}
}
