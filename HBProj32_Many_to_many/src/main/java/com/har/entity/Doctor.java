package com.har.entity;

import java.util.Set;

import lombok.Data;

@Data
public class Doctor {

	private Integer doctorId;
	private String doctorName;
	private String doctorQlf;
	private String hospital;
	////Uni-directional   :: Only one side we have use Collection-Property with many-to-many
    private	Set<Patient> patients;    	  //To build many-to=many

}
