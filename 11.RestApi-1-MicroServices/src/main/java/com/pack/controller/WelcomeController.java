package com.pack.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/welcome")
public class WelcomeController 
{
	@GetMapping(value = "/welcome")
	public String message()
	{
		String str = "Welcome To Spring Rest Api -01 "+LocalDate.now();
		return str;
	}
}
