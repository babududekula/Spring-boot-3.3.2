package com.pack.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController 
{
	@GetMapping(value = "/get")
	public String name(Principal principal)
	{
		String name = principal.getName();
		return "Welcome To Oauth Security "+name+" Stay Connected and do Connections";
	}
}
