package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.pojo.Address;
import com.pack.service.AddressService;

@RestController
public class AddressController
{
	@Autowired
	private AddressService addService;
	
	@PostMapping(value = "/addAddress")
	public String addDataToDataBaseTable(@RequestBody Address address)
	{
		String addDateOrUpdateData = addService.addDateOrUpdateData(address);
		return addDateOrUpdateData;
	}
}
