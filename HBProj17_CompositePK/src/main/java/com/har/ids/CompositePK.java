package com.har.ids;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompositePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int isbn;               //International Standard Book Number
    private String bookName;
	
}
