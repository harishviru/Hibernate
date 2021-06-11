package com.har.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue(value="EMPLOYEE_ANNO")
public class EmployeeAnno  extends PersonAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String designation;
	private Double salary;
	private String address;  
	
	
}
