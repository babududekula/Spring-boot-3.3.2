package com.pack.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE_DETAILS_TABLE")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	private String employeeName;
	private Integer employeeAge;
	private String employeeAddress;
	private Double employeeSalary;
	private Long employeeIdCardNumber;
	private String employeeDepartment;
	@CreationTimestamp
	@Column(name = "EMPLOYEE_CREATION_DATE", updatable = false)
	private LocalDateTime employeeCreationDate;
	@UpdateTimestamp
	@Column(name = "EMPLOYEE_UPDATION_DATE" ,insertable = false)
	private LocalDateTime employeeUpdationDate;
}
