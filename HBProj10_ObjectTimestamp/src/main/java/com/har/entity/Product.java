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
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6845292046992946422L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_Id",unique=false,nullable=false)
	private Integer prodId;
	
	@Column(name="product_name")
	private String productName;
	@Column(name="prod_price")
	private Double prodPrice;
	
	
  	/*@CreationTimestamp
	  private Date createdOn;
	  @UpdateTimestamp
	  private Date updatedOn; */
	
	  @CreationTimestamp
	  private Timestamp createdOn;
	  @UpdateTimestamp
	  private Timestamp updatedOn;

	 /* 
	@CreationTimestamp
	  private LocalDateTime createdOn;
	  @UpdateTimestamp
	  private LocalDateTime updatedOn; */
   
	
}
