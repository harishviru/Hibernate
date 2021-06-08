package com.har.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;


@Data
@Embeddable
public class BookAnnoComPk02 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int isbn;               //International Standard Book Number
    private String bookName;
	
	
}
