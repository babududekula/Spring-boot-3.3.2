package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.pojo.Student;
import com.pack.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository studRepository;
	
	public String addDateOrUpdateData(Student student)
	{
		String str = "";
		Integer studentId = student.getStudentId();
		if(studentId == null)
		{
			studRepository.save(student);
			str = "Student Data Successfully Added...";
		}
		else
		{
			studRepository.save(student);
			str = "Student Data Updated Successfully...";
		}
			
		return str;
	}
}
