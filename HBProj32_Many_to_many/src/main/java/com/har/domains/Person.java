package com.har.domains;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_Id")
	private Integer personId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	//Bi-directional :: With Default Table name as "Person_cars"
/*   @ManyToMany(cascade=CascadeType.ALL)	
	private Set<Car> cars;*/
	
	//Bi-directional :: With custom Table name as "person_cars_tab"
	   @ManyToMany(cascade=CascadeType.ALL)	
	   @JoinTable(name="person_cars_tab",joinColumns={@JoinColumn(name="person_id")},
	      inverseJoinColumns={@JoinColumn(name="car_id")}
		  )
		private Set<Car> cars;
	
	
}
