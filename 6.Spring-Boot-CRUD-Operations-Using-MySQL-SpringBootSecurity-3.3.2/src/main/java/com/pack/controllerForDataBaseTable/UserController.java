package com.pack.controllerForDataBaseTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entityForDataBaseTable.UserCredentials;
import com.pack.serviceDataBaseTable.UserServiceClass;


@RestController
@RequestMapping(value = "/table")
public class UserController 
{
	@Autowired
	private UserServiceClass service;
	
	@PostMapping(value = "/addUser")
	public ResponseEntity<UserCredentials> addData(@RequestBody UserCredentials user)
	{
		UserCredentials addData = service.addData(user);
		return new ResponseEntity<UserCredentials>(addData, HttpStatus.CREATED);
	}
}
