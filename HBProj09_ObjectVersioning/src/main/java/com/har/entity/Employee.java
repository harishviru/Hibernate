package com.har.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

	private Integer empId;
	private String empName;
	private String position;
	private Double salary;
	private Integer version;
	
}
