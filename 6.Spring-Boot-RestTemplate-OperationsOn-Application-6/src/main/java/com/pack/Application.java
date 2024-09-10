package com.pack;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeService bean = context.getBean(EmployeeService.class);
		bean.getAllData();
	}
	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}
	
	@Bean
	public WebClient webClient()
	{
		return WebClient.builder()
				.defaultHeader("Authorization", "Bearer your_token_here")
                .defaultHeader("Accept", "application/json")
				.build();
	}
	
	@Bean
    public ObjectMapper objectMapper()
	{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature(), true);
        return objectMapper;
	}
}
