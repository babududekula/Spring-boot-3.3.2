package com.pack.aadharService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.aadharrepository.AadharRepository;
import com.pack.entity.Aadhar;

@Service
public class AadharService 
{
	@Autowired
	private AadharRepository repository;

	
	public Aadhar addData(Aadhar aadhar)
	{
		Aadhar save = repository.save(aadhar);
		return save;
	}
	
	public Aadhar getData(Integer id)
	{
		Optional<Aadhar> byId = repository.findById(id);
		if(byId.isEmpty())
		{
			return null;
		}
		else
		{
			return byId.get();
		}
	}
}
