package com.pack.panService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.panrepository.PanCardRepository;
import com.pack.pojo.PanCard;

@Service
public class PanCardService 
{
	@Autowired
	private PanCardRepository repository;
	
	public PanCard addData(PanCard panCard)
	{
		PanCard save = repository.save(panCard);
		return save;
	}
	
	public PanCard getData(Integer id)
	{
		Optional<PanCard> findById = repository.findById(id);
		if(findById.isEmpty())
		{
			return null;
		}
		else
		{
			return findById.get();
		}
	}
}
