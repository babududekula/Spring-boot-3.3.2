package com.pack.entity;

import lombok.Data;

@Data
public class Product 
{
	private Integer productId;
	private String productPersonFirstName;
	private String productPersonLastName;
	private String productName;
	private Double productCost;
}
