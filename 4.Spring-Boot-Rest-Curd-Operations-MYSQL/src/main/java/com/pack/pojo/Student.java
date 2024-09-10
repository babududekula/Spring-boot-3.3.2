package com.pack.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "STUDENTS_INFORMATION_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String studentName;
	private Integer studentAge;
	private Long studentIDNumber;
	private String studentCourse;
	@OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	
	
}
