package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Employee;
import com.pack.service.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	@PostMapping(value = "/addData")
	public ResponseEntity<String> addData(@RequestBody Employee employee)
	{
		String setData = service.setData(employee);
		return new ResponseEntity<String>(setData, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<String> getById(@PathVariable Integer id)
	{
		String data = service.getData(id);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Employee>> findAll()
	{
		List<Employee> all = service.getAll();
		all.forEach(System.out::println);
		return new ResponseEntity<List<Employee>>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/ADD")
	public ResponseEntity<Employee> postData(@RequestBody Employee employee)
	{
		Employee addDataThroughWebClient = service.addDataThroughWebClient(employee);
		return new ResponseEntity<Employee>(addDataThroughWebClient, HttpStatus.CREATED);
	}
}
