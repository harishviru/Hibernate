package com.har.entity;

import java.io.Serializable;

import com.har.ids.CompositePK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//#01 :: Normal Composite PK
/*	private int isbn;               //International Standard Book Number
    private String bookName;
    private String authorName;
    private String category;
    private Double price;*/
	
	//#02 ::  Composite PK as seperate class
	private CompositePK compk;          //HAS -A property to suppport composite Id    
    private String authorName;
    private String category;
    private Double price ;
    
}
