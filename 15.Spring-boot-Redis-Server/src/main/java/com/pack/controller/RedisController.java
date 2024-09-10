package com.pack.controller;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Address;

@RestController
public class RedisController 
{
	HashOperations<String, Integer, Address> hashOperations;
	public RedisController(RedisTemplate<String, Address> redisTemplate) 
	{
		 hashOperations = redisTemplate.opsForHash();
	}
	
	@PostMapping(value = "/addData")
	public String addData(@RequestBody Address address)
	{
	String message = "";
	Integer uid = address.getId();
	if(uid != null)
	{
		hashOperations.put("ADDRESS", address.getId(), address);
		message = "Updation Has Completed...";
	}
	message = "Insertion Has Completed";
	return message;
}
	
	@GetMapping(value = "/getData/{id}")
	public Address getData(@PathVariable Integer id)
	{
		Address address = hashOperations.get("ADDRESS", id);
		return address;
	}
	
	@GetMapping(value = "/getAll")
	public List<Address> getAll()
	{
		List<Address> values = hashOperations.values("ADDRESS");
		return values;
	}
	
	@DeleteMapping(value = "/deleteData/{id}")
	public String deleteData(@PathVariable Integer id)
	{
		String message = String.valueOf(hashOperations.delete("ADDRESS", id)); 
		return message+" Successfully Deleted...";
	}
}
