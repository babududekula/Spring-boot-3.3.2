package com.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "Home Service Documentation"))
public class Application 
{

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		/*
		 * Home home = new Home(); home.setHomeName("Meeravali'Home");
		 * home.setHomeAddress("Venkatagiri");
		 * 
		 * People people = new People(); people.setFatherName("Meeravali");
		 * people.setMotherName("Eesubi"); people.setHome(home);
		 * 
		 * People people1 = new People(); people1.setFatherName("Masthan");
		 * people1.setMotherName("Haseena"); people1.setHome(home);
		 * 
		 * People people2 = new People(); people2.setFatherName("Nagesh");
		 * people2.setMotherName("Saleema"); people2.setHome(home);
		 * 
		 * List<People> asList = Arrays.asList(people,people1,people2);
		 * home.setPeople(asList);
		 * 
		 * HomeRepository repository = context.getBean(HomeRepository.class); Home save
		 * = repository.save(home); System.out.println("Successfully Saved...");
		 */
	}

}
