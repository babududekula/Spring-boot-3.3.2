package com.pack.reposiotoryDataBaseTable;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entityForDataBaseTable.UserCredentials;

public interface UserRepository extends JpaRepository<UserCredentials, Integer>
{
	public Optional<UserCredentials> findByUsername(String username); 
}
