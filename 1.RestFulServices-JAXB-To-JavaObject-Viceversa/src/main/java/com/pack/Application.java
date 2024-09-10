package com.pack;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pack.entity.Employee;

@SpringBootApplication
public class Application 
{

	public static void main(String[] args) throws JAXBException 
	{
		SpringApplication.run(Application.class, args);
		Employee employee = new Employee();
		employee.setName("Babu");
		employee.setAge(20);
		employee.setAddress("Hyd");
		employee.setSalary(2345.43);
		
//		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
//		Marshaller createMarshaller = jaxbContext.createMarshaller();
//		createMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		createMarshaller.marshal(employee, System.out);
//		createMarshaller.marshal(employee, new File("employee.xml"));
//		
//		
//		System.out.println("==========================================================");
//		
//		JAXBContext jaxbContext1 = JAXBContext.newInstance(Employee.class);
//		Unmarshaller unmarshaller = jaxbContext1.createUnmarshaller();
//		Object object = unmarshaller.unmarshal(new File("employee.xml"));
//		Employee employee1 = (Employee) object;
//		System.out.println(employee1);
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(employee, System.out);
		marshaller.marshal(employee, new File("employee.xml"));
		
		System.out.println("============================================================");
		
		JAXBContext jaxbContext2 = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext2.createUnmarshaller();
		Object object = unmarshaller.unmarshal(new File("employee.xml"));
		Employee emp = (Employee) object;
		System.out.println(emp);
		
		
	}

}
