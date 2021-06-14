package com.har.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

//Child
@NoArgsConstructor
@Data
public class Employee {

	private Integer employeeId;
	private String empName;
	private Double salary;
	private Department department;
	
}
