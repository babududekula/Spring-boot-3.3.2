package com.pack.controler1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pack.customException.NoSuchClassFoundException;

@RestController
public class NameController 
{
	@GetMapping(value = "/getC/{name}")
	public String name(@PathVariable String name)
	{
		String message = "";
		if(name.equals("Babu"))
		{
			message = name + "Dudekula";
		}
		else
		{
			throw new NoSuchClassFoundException("Not Found Related Name ...");
		}
		return message;
	}
}
