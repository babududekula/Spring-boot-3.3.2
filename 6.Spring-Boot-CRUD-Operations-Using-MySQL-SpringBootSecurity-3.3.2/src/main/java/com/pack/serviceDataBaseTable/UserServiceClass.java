package com.pack.serviceDataBaseTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pack.entityForDataBaseTable.UserCredentials;
import com.pack.reposiotoryDataBaseTable.UserRepository;

@Service
public class UserServiceClass 
{
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UserCredentials addData(UserCredentials user)
	{
		String encode = encoder.encode(user.getPassword());
		user.setPassword(encode);
		UserCredentials userCredentials = repository.save(user);
		return userCredentials;
	}
}
