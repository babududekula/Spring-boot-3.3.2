package com.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "EMPLOYEE_dOCUMENTATION"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
