package com.pack.restController;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.binding.Event;

@RestController
@RequestMapping("/event-manage")
public class EventController 
{

	@GetMapping(value = "/get/{id}" , 
			produces = {"application/xml","application/json"}
			)
	public ResponseEntity<Event> getData(@PathVariable Integer id)
	{
		Event event = new Event();
		event.setEventId(1);
		event.setEventName("Marriage");
		event.setEventType("Big-Event");
		event.setEventAmount(98765.90);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@GetMapping("/getQuery")
	public ResponseEntity<String> getDataUsingQueryParam(@RequestParam String name , @RequestParam String experience)
	{
		String str = "My Name is "+name+" and I have an "+experience +" ......";
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/getPath/{age}/{name}")
	public ResponseEntity<String> getDataUsingPathVariable(@PathVariable Integer age , @PathVariable String name)
	{
		String str = "My Name is "+name+" and I am "+age+" Years age Old";
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllData")
	public ResponseEntity<List<Event>> getAllData()
	{
		Event event = new Event(2, "Function", "Small", 34564.90);
		Event event1 = new Event(4, "Reception", "Big-Function", 24564.90);
		Event event2 = new Event(3, "Marriage", "Small-Marriage", 134564.90);
		Event event3 = new Event(6, "Engagement", "Small-Engagement", 234564.90);
		
		List<Event> asList = Arrays.asList(event,event1,event2,event3);
		return new ResponseEntity<List<Event>>(asList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/addEvent" ,
				consumes = {"application/xml","application/json"}
				)
	// Consumer attribute is going to accept which type is client is sending the data
	// content-type header is going to take the input type from the client through Request body
	// Produces attribute is going to produce which format you are sending output
	// Accept header is used to accept the in which format client is accepting the response
	
	public ResponseEntity<Event> addEvent(@RequestBody Event event)
	{
		System.out.println(event);
		return new ResponseEntity<Event>(event, HttpStatus.CREATED);
	}
}
