package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.feignClient.FeignClientClass;

@RestController
@RequestMapping(value = "/wish")
public class AccessController 
{
	@Autowired
	private FeignClientClass feignClient;
	
	@GetMapping(value = "/wish/{name}")
	public String msg(@PathVariable String name)
	{
		String message = feignClient.message();
		String str = "Hello "+name+" The Spring Boot is Wishing you ...And..."+message;
		return str;
	}
}
