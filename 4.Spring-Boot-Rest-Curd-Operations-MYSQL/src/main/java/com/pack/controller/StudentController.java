package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.pojo.Student;
import com.pack.service.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/addStudent")
	public String addDataToDataBaseTable(@RequestBody Student student)
	{
		String addDateOrUpdateData = studentService.addDateOrUpdateData(student);
		return addDateOrUpdateData;
	}
}
