package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.pojo.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> 
{
	
}
