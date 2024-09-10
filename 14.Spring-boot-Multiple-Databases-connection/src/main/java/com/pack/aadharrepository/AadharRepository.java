package com.pack.aadharrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Aadhar;

public interface AadharRepository extends JpaRepository<Aadhar, Integer> 
{
	
}
