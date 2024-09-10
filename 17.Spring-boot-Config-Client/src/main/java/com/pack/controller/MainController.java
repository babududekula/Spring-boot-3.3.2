package com.pack.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MainController 
{
	@Value("${greet}")
	private String message;
	
	@Value("${message}")
	private String message2;
	
	@GetMapping(value = "/get1")
	public String name()
	{
		return "Hello Babu This is Cloud Config Greeting message From ..."+message;
	}
	
	@GetMapping(value = "/get2")
	public String name1()
	{
		return "Hello Babu This is Cloud Config Message from..."+message2;
	}
}
