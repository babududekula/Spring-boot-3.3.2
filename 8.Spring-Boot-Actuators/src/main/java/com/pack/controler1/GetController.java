package com.pack.controler1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController 
{
	@GetMapping(value = "/getB/{name}")
	public String getData(@PathVariable String name)
	{
		String str = null;
		if(str.equals(name))
		{
			System.out.println("Good");
		}
		else
		{
			throw new RuntimeException();
		}
		return str;
		
	}
}
