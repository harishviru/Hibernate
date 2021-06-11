package com.har.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="person_tab")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)   
@DiscriminatorColumn(name="person_type",discriminatorType=DiscriminatorType.STRING) //equal to   <discriminator> tag
@DiscriminatorValue("PERSON_ANNO")
@Polymorphism(type=PolymorphismType.EXPLICIT)
public  class PersonAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer personId;
	@Column(name="person_name")
	private String personName;
	
}
