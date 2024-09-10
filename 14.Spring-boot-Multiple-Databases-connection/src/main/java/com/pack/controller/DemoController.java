package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.aadharService.AadharService;
import com.pack.entity.Aadhar;
import com.pack.panService.PanCardService;
import com.pack.pojo.PanCard;

@RestController
public class DemoController 
{
	@Autowired
	private AadharService service;
	
	@Autowired
	private PanCardService service1;
	
	@PostMapping(value = "/addAadhar")
	public ResponseEntity<Aadhar> addData(@RequestBody Aadhar data)
	{
		Aadhar addData = service.addData(data);
		return new ResponseEntity<Aadhar>(addData, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/addPanCard")
	public ResponseEntity<PanCard> addData1(@RequestBody PanCard panCard)
	{
		PanCard addData = service1.addData(panCard);
		return new ResponseEntity<PanCard>(addData, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAadhar/{id}")
	public ResponseEntity<Aadhar> getData(@PathVariable Integer id)
	{
		Aadhar data = service.getData(id);
		return new ResponseEntity<Aadhar>(data, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPanCard/{id}")
	public ResponseEntity<PanCard> getData1(@PathVariable Integer id)
	{
		PanCard data = service1.getData(id);
		return new ResponseEntity<PanCard>(data, HttpStatus.OK);
	}
}
