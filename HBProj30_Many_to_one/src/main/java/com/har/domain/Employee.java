package com.har.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.har.domain.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

//Child
@NoArgsConstructor
@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_Id")
	private Integer employeeId;
	
	@Column(name="emp_name")
	private String empName;
	private Double salary;
	
	@ManyToOne(targetEntity=Department.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER) // cascade="all"
	@JoinColumn(name="department_id",referencedColumnName="department_Id")
	@LazyToOne(LazyToOneOption.NO_PROXY)    // lazy="no-proxy"
	private Department department;
	
}
