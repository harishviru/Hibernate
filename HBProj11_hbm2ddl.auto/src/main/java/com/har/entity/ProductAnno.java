package com.har.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="product")
public class ProductAnno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6845292046992946422L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id",unique=false,nullable=false)
	private Integer prodId;
	
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private Double prodPrice;

}
