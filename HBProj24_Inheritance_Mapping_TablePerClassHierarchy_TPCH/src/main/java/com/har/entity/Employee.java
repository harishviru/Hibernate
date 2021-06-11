package com.har.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee  extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String designation;
	private Double salary;
	private String address;  
	
	
}
