package com.har.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4707625803596360518L;
	
	private Integer studentId;
	private String firstName;
	private String lastName;
	private Integer marks;
	private String grade;
	
	
}
