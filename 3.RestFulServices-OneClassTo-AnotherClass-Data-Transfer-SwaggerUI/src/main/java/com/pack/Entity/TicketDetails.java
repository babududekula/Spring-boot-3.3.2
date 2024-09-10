package com.pack.Entity;

import lombok.Data;

@Data
public class TicketDetails 
{
	private String firstName;
	private String lastName;
	private String busNumber;
	private String from;
	private String to;
	private String status;
	private Double price;
	private String busBordingPoint;
	private String busSeatNumber;
	private String busCapacity;
	
}
