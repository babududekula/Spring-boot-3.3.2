package com.pack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArthematicController 
{
	@GetMapping("/getA")
	public String getData()
	{
		String str = "Welcome To Spring boot...";
		try 
		{
			int i = 20/0;
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(str, e);
		}
		return str;
	}
}
