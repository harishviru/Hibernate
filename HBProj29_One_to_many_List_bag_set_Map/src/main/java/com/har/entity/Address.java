package com.har.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

	private Integer addressId;
	private String street;
	private String city;
	private String state;
	
}
