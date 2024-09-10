package com.pack.fromDataBaseTodetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pack.databasetoourclass.UserDetailsDTO;
import com.pack.entityForDataBaseTable.UserCredentials;
import com.pack.reposiotoryDataBaseTable.UserRepository;

public class UserDetailsServiceClass implements UserDetailsService
{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserCredentials> findByUsername = repository.findByUsername(username);
		return findByUsername.map(UserDetailsDTO::new).orElseThrow(()->new UsernameNotFoundException("Sorry...User Not Found here"));
	}
	
}
