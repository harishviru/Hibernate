package com.har.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.har.ids.BookAnnoComPk01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//#01 With @Idclass

@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(BookAnnoComPk01.class)
@Entity
@Table(name="book_anno")
public class BookAnno01 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int isbn;               //International Standard Book Number
	@Id
    private String bookName;
    private String authorName;
    private String category;
    private Double price;
	
}
