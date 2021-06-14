package com.har.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

	private Integer personId;
	private String personName;
	private List<Address> addressList;
	private List<Vehicle> vehicleList;
	private Set<BankAccount> bankAccountSet;
	private Map<String,Country> placedVistedMap;
	
}
