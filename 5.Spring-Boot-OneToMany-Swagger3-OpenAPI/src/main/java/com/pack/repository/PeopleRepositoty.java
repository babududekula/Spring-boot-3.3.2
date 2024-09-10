package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.pojo.People;

public interface PeopleRepositoty extends JpaRepository<People, Integer> 
{
	
}
