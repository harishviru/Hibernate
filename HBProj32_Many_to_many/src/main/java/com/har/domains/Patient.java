package com.har.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_Id")
	private Integer patientId;
	@Column(name="patient_name")
	private String patientName;
	@Column(name="patient_addrs")
	private String patientAddrs;
	private String problem;
	
}
