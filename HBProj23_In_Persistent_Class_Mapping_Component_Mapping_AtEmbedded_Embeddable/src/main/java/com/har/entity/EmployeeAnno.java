package com.har.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employee_tab")
public class EmployeeAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4707625803596360518L;
	
	@Id
	@Column(name="employee_id")
/*	@GeneratedValue(generator="incre")
	@GenericGenerator(name="incre",strategy="increment")*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(name="emp_name")
	private String empName;
	@Column(name="designation")
	private String designation;
	@Column(name="salary")
	private Double salary;
	@Embedded
	private AddressAnno address;  //Component type mapping  by using @Embedded
	
}
