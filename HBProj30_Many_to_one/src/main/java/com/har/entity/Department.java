package com.har.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

//Parent
@NoArgsConstructor
@Data
public class Department {

	private Integer departmentId;
	private String dname;
	private String location;
	
}
