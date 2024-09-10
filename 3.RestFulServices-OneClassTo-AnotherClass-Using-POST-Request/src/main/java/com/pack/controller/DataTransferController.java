package com.pack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Person;
import com.pack.entity.Product;

@RestController
public class DataTransferController 
{
	@PostMapping(value = "/addData" ,
				consumes = {"application/json"} , 
				produces = {"application/xml","application/json"}
				)
	public ResponseEntity<Product> getOrder(@RequestBody Person person)
	{
		Product product = new Product();
		product.setProductId(person.getPersonId());
		product.setProductName(person.getProductName());
		product.setProductPersonFirstName(person.getPersonFirstName());
		product.setProductPersonLastName(person.getPersonLastName());
		product.setProductCost(34563.56);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
