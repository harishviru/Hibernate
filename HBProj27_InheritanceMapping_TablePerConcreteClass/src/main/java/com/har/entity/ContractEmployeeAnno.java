package com.har.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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
@Table(name="CONTRACT_EMPLOYEE_Concrete_SUB")
@AttributeOverrides({       // Optional 
    @AttributeOverride(name="personId",column= @Column(name="person_id")),
    @AttributeOverride(name="personName",column=@Column(name="person_name"))
})
public class ContractEmployeeAnno  extends PersonAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String location;
	@Column(name="contract_period")
	private Float contractPeriod;
	
}
