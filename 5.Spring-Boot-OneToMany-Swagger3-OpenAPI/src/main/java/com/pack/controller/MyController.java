package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Home;
import com.pack.repository.HomeRepository;

@RestController
public class MyController 
{
	@Autowired
	private HomeRepository repo;
	
	@GetMapping(value = "/getAll")
	public List<Home> getAll()
	{
		List<Home> findAll = repo.findAll();
		return findAll;
	}
}
