package com.har.entity;

import java.util.Set;

import lombok.Data;

@Data
public class Person {

	private Integer personId;
	private String firstName;
	private String lastName;
	private Set<Car> cars;
	
}
