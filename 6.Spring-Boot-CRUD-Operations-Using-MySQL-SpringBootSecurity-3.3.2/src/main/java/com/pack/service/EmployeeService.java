package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.pack.entity.Employee;
import com.pack.repository.EmployeeRepository;

@Service
@Profile(value = {"dev" , "prod" , "uat"})
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository repository;
	
	public String addDataOrUpdateData(Employee employee)
	{
		String str = "";
		Integer employeeId = employee.getEmployeeId();
		repository.save(employee);
		if(employeeId == null)
		{
			str = "Employee Successfully Added...";
		}
		else
		{
			str = "Employee Updated Successfully...";
		}
		return str;
	}
	
	public Employee getEmployeeById(Integer id)
	{
		Employee employee= null;
		Optional<Employee> findById = repository.findById(id);
		if(findById.isPresent())
		{
			employee = findById.get();
		}
		return employee;
	}
	
	public List<Employee> getAll()
	{
		List<Employee> findAll = repository.findAll();
		return findAll;
	}
	
	public String deleteEmployee(Integer id)
	{
		String str = "";
		Optional<Employee> findById = repository.findById(id);
		if(findById.isPresent())
		{
			repository.deleteById(id);
			str = "Employee Deleted By Id "+id;
		}
		else
		{
			str = "Employee Not Found Based On Id Number "+id;
		}
		return str;
	}
}
