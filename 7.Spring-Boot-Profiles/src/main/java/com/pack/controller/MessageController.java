package com.pack.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.binding.Messages;

@RestController
public class MessageController
{
	@Value("${Welcome.message}")
	private String msg1;
	
	@Value("${Greet.message}")
	private String msg2;
	
	@Value("${Wish.message}")
	private String msg3;
	
	@Autowired
	private Messages msg;
	
	@GetMapping(value = "/welcome")
	public String welcome()
	{
		return msg1;
	}
	
	@GetMapping(value = "/greet")
	public String greet()
	{
		return msg2;
	}
	
	@GetMapping(value = "/wish")
	public String wish()
	{
		return msg3;
	}
	
	@GetMapping(value = "/Welcome")
	public String m1()
	{
		Map<String, String> map = msg.getMap();
		String string = map.get("hello");
		return string;
	}
	
	@GetMapping(value = "/Greet")
	public String m2()
	{
		Map<String, String> map = msg.getMap();
		String string = map.get("hai");
		return string;
	}
	
	@GetMapping(value = "/Wish")
	public String m3()
	{
		Map<String, String> map = msg.getMap();
		String string = map.get("bye");
		return string;
	}
}
