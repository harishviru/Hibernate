package com.har.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//Parent
@NoArgsConstructor
@Data
@Entity
@Table(name="department")
public class Department {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_Id")
	private Integer departmentId;
	private String dname;
	private String location;
	
}