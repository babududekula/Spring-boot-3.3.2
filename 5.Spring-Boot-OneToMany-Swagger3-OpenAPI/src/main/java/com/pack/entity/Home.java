package com.pack.entity;

import java.util.List;

import com.pack.pojo.People;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HOME_DETAILS")
public class Home 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer homeId;
	private String homeName;
	private String homeAddress;
	@OneToMany(mappedBy = "home",cascade = CascadeType.ALL)
	private List<People> people;
}
