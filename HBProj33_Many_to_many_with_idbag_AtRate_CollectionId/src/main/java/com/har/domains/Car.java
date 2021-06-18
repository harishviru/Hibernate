package com.har.domains;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="car")
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="car_Id")
	private Integer carId;
	@Column(name="car_name")
	private String carName;
	private String modal;
	
	/* @ManyToMany()
	private Set<Person> people; */     //For Build many-to-many association
	 
	 @ManyToMany(mappedBy="cars")
	private Set<Person> people;      //For Build many-to-many association
}
