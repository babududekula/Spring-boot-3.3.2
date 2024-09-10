package com.pack.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.pack.entity.Employee;


@Service
public class EmployeeService 
{
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient.Builder webClient;
	
	public String setData(Employee employee)
	{
		String url ="http://localhost:1111/employee/add";
		
		ResponseEntity<String> postForEntity = template.postForEntity(url, employee, String.class);
		String body = postForEntity.getBody();
		return body;
	}
	
	@SuppressWarnings("deprecation")
	public String getData(Integer id)
	{
		String body ="";
		String url = "http://localhost:1111/employee/get/{id}";
		ResponseEntity<String> forEntity = template.getForEntity(url, String.class, id);
		int statusCodeValue = forEntity.getStatusCodeValue();
		if(statusCodeValue == 200)
		{
			body = forEntity.getBody();
		}
		return body;
	}
	
	public List<Employee> getAll()
	{
		String url = "http://localhost:1111/employee/getAll";
		ResponseEntity<Employee[]> forEntity = template.getForEntity(url, Employee[].class);
		Employee[] body = forEntity.getBody();
		List<Employee> asList = Arrays.asList(body);
		return asList;
	}
	
	// ===================Web-Client===============================================================
	
	public Employee addDataThroughWebClient(Employee employee)
	{
		/*
		 * Employee employee = new Employee();
		 * employee.setEmployeeAddress("Pathagunta"); employee.setEmployeeAge(22);
		 * employee.setEmployeeDepartment("Developer");
		 * employee.setEmployeeIdCardNumber(9232L);
		 * employee.setEmployeeName("Venkatesh"); employee.setEmployeeSalary(33234.54);
		 */
		String url = "http://localhost:1111/employee/add";
		
		Employee block = webClient.build().post()
		.uri(url)
		.bodyValue(employee)
		.retrieve()
		.bodyToMono(Employee.class)
		.block();
		return block;
	}
	
	public void getAllData()
	{
		String url = "http://localhost:1111/employee/getAll";
		webClient.build()
		.get()
		.uri(url)
		.retrieve()
		.bodyToMono(Employee.class)
		.subscribe(EmployeeService::method1);
	}
	public static void method1(Employee employee)
	{
		System.out.println("This is my Static Reference method");
		System.out.println(employee);
	}
	
}
