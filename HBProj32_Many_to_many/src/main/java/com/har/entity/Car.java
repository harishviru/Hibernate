package com.har.entity;

import java.util.Set;

import lombok.Data;

@Data
public class Car {

	private Integer carId;
	private String carName;
	private String modal;
	
	private Set<Person> people;
}
