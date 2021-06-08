package com.har.ids;

import java.io.Serializable;

import lombok.Data;


@Data
public class BookAnnoComPk01 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int isbn;               //International Standard Book Number
    private String bookName;
	
	
}
