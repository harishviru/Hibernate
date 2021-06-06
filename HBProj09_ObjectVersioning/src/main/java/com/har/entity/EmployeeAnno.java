package com.har.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employee")
public class EmployeeAnno {

	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private Integer empId;
	// In hibernate mapping file/Entity class,we can add an element like <version> /@Version annotation  soon after id element .
	@Version
	private Integer version;
	@Column(name="emp_name")
	private String empName;
	//Here column and property name are same,so that not required use @Column annotation
	private String position;
	//Here column and property name are same,so that not required use @Column annotation
	private Double salary;
	
}
