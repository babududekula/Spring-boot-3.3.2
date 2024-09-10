package com.pack.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "employee")
@XmlAccessorOrder
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee 
{
	private String name;
	private Integer age;
	private String address;
	private Double salary;
}
