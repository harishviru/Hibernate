package com.har.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue(value="CONTRACT_EMPLOYEE_ANNO")
public class ContractEmployeeAnno  extends PersonAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String location;
	@Column(name="contract_period")
	private Float contractPeriod;
	
}
