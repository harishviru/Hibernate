package com.har.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="CONTRACT_EMPLOYEE_JOINED_SUB_02")
@PrimaryKeyJoinColumn(name="person_Cemp_Id")
public class ContractEmployeeAnno  extends PersonAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String location;
	@Column(name="contract_period")
	private Float contractPeriod;
	
}
