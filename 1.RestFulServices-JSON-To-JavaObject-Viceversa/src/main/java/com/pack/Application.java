package com.pack;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.entity.Address;
import com.pack.entity.Mobile;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		SpringApplication.run(Application.class, args);
		
		Mobile mobile = new Mobile();
		mobile.setName("Iphone");
		mobile.setAddress("Hyd");
		mobile.setCost(25000);
		
		Address address = new Address();
		address.setAdd1("VGR");
		address.setAdd2("ONG");
		address.setAdd3("NLR");
		
		mobile.setAdd(address);
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("mobile.json"), mobile);
		System.out.println("Data converted");
		
		System.out.println("=========================================");
		
		ObjectMapper objectMapper1 = new ObjectMapper();
		Mobile mobile2 = objectMapper1.readValue(new File("mobile.json"), Mobile.class);
		System.out.println(mobile2);
	
	}

}
