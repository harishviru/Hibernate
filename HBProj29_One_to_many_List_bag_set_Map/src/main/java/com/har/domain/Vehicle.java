package com.har.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_Id")
	private Integer vehicleId;
	
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Column(name="vehicle_owner_name")
	private String vehicleOwnerName;
	
}
