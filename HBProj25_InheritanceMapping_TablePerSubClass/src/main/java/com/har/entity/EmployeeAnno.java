package com.har.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="EMPLOYEE_JOINED_SUB_01")
@PrimaryKeyJoinColumn(name="person_emp_Id")
public class EmployeeAnno  extends PersonAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String designation;
	private Double salary;
	private String address;  
	
	
}
