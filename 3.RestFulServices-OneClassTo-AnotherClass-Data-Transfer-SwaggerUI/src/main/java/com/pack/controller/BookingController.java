package com.pack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.Entity.BusDetails;
import com.pack.Entity.TicketDetails;

@RestController
public class BookingController 
{
	@PostMapping(value = "/addData",
				produces = {"application/json"},
				consumes = {"application/xml","application/json"}
				)
	public ResponseEntity<TicketDetails> getTicketDetails(@RequestBody BusDetails busDetails)
	{
		TicketDetails ticketDetails = new TicketDetails();
		ticketDetails.setFirstName(busDetails.getFirstName());
		ticketDetails.setLastName(busDetails.getLastName());
		ticketDetails.setBusBordingPoint(busDetails.getBusBordingPoint());
		ticketDetails.setBusCapacity("36-Passengers");
		ticketDetails.setBusNumber(busDetails.getBusNumber());
		ticketDetails.setBusSeatNumber(busDetails.getBusSeatNumber());
		ticketDetails.setFrom(busDetails.getFrom());
		ticketDetails.setTo(busDetails.getTo());
		ticketDetails.setPrice(busDetails.getPrice());
		ticketDetails.setStatus("Confirmed Successfully");
		System.out.println(ticketDetails);
		return new ResponseEntity<>(ticketDetails, HttpStatus.CREATED);
	}
}
