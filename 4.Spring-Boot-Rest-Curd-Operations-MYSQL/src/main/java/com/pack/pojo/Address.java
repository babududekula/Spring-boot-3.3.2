package com.pack.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ADDRESS_INFORMATION_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	private String streetName;
	private String villageName;
	private String stateName;
	private String pincodeName;
	@ManyToOne
	@JoinColumn(name = "MY_ID")
	private Student student;
}
