package com.har.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_Id")
	private Integer personId;
	
	@Column(name="person_name")
	private String personName;
	
	//#01. List 
	@OneToMany(targetEntity=Address.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	@OrderColumn(name="address_index")    //index colum cfg
	@ListIndexBase(value=1) // // index col base value
	private List<Address> addressList;
	
	//#02. Bag
	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	private List<Vehicle> vehicleList;
	
	//#03 .Set
	@OneToMany(targetEntity=BankAccount.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	private Set<BankAccount> bankAccountSet;
	
	//#04 .Map
	@OneToMany(targetEntity=Country.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	@MapKeyColumn(name="map_key_index",length=20)
	private Map<String,Country> placedVistedMap;
}
