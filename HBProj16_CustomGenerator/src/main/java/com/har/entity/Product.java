package com.har.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6845292046992946422L;
	
	
	
	private Integer prodId;
	private String productName;
	private Double prodPrice;
	
}
