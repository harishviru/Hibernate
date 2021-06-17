package com.har.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_Id")
	private Long vehicleId;
	@Column(name="vehicle_name")
	private String vehicleName;
	@Column(name="company_name")
	private  String companyName;
	@ManyToOne
	@JoinColumn(name="owner_id",referencedColumnName="owner_Id")
	private  Owner  owner;  //To build many to One Association
	
	
}
