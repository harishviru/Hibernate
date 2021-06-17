package com.har.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="onwer")
public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="owner_Id")
	private Integer ownerId;
	@Column(name="owner_name")
	private String  ownerName;
	@Column(name="owner_addrs")
	private String ownerAddrs;
	
//	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinTable(name="own_vehicles",joinColumns={@JoinColumn(name="owner_id")},
//	                   inverseJoinColumns={@JoinColumn(name="vehicle_Id")}
//			)
	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="owner")
	private Set<Vehicle> vehicles;   //for One To Many Association //If mappedBy is there,then @JoinColumn,@JoinTable must not use,If mappedBy is there then propery (vehicle) entity is Onwer
	
}
