package com.har.entity;

import java.util.Set;

import lombok.Data;

@Data
public class Patient {

	
	private Integer patientId;
	private String patientName;
	private String patientAddrs;
	private String problem;
	
	 
//	private Set<Doctor> doctors;   //To build many-to-many association
	
}
