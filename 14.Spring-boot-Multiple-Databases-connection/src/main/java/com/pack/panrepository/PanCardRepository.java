package com.pack.panrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.pojo.PanCard;

@Repository
public interface PanCardRepository extends JpaRepository<PanCard, Integer> 
{
	
}
