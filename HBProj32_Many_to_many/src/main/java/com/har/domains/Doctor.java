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
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_Id")
	private Integer doctorId;
	@Column(name="doctor_name")
	private String doctorName;
	@Column(name="doctor_Qlf")
	private String doctorQlf;
	private String hospital;
   ////Uni-directional   :: Only one side we have use Collection-Property with many-to-many
	/*@ManyToMany(cascade=CascadeType.ALL)                              //Default table name as "Doctor_patients"
	 private	Set<Patient> patients;    	  //To build many-to=many 
*/	
	
	// With custom table name as "doc_patients"
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="doc_patients",joinColumns={@JoinColumn(name="doctor_Id")},
	       inverseJoinColumns={@JoinColumn(name="patient_id")}
	  )
	 private	Set<Patient> patients;    	  //To build many-to=many
	
	
	
}
