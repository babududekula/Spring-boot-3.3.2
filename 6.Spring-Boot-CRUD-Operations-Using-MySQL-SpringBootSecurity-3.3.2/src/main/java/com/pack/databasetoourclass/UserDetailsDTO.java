package com.pack.databasetoourclass;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pack.entityForDataBaseTable.UserCredentials;

public class UserDetailsDTO implements UserDetails
{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	
	public UserDetailsDTO(UserCredentials credentials) 
	{
		username = credentials.getUsername();
		password = credentials.getPassword();
		roles    = Arrays.stream(credentials.getRoles().split(",")).
				map(SimpleGrantedAuthority::new).
				collect(Collectors.toList());
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return roles;
	}

	@Override
	public String getPassword() 
	{
		return password;
	}

	@Override
	public String getUsername() 
	{
		return username;
	}
	
}
