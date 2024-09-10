package com.pack.circuitbreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController 
{
	@GetMapping("/firstRestApi")
	public String getMessageFromFirstRestApiFallBack()
	{
		return "Sorry ...Currently RestApi-1 Service is down please try later...";
	}
	
	@GetMapping("/fallbackLogicForApi2")
	public String getMessageFromSecondRestApiFallBack()
	{
		return "Sorry ...Currently RestApi-2 Service is down please try later...";
	}
}
