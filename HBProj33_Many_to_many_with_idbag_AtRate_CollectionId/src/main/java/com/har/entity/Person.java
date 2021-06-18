package com.har.entity;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Person {

	private Integer personId;
	private String firstName;
	private String lastName;
	private List<Car> cars;      // for many-to-many association
	
}
