package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.pojo.Address;
import com.pack.repository.AddressRepository;
@Service
public class AddressService 
{
	@Autowired
	private AddressRepository addRepository;
	
	public String addDateOrUpdateData(Address address)
	{
		String str = "";
		Integer studentId = address.getAddressId();
		if(studentId == null)
		{
			addRepository.save(address);
			str = "Student Data Successfully Added...";
		}
		else
		{
			addRepository.save(address);
			str = "Student Data Updated Successfully...";
		}
			
		return str;
	}
}
