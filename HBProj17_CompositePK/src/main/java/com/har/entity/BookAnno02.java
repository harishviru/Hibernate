package com.har.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.har.ids.BookAnnoComPk01;
import com.har.ids.BookAnnoComPk02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//#02 With @EmbeddedId

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="book_anno")
public class BookAnno02 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
   private BookAnnoComPk02 comPk;
    private String authorName;
    private String category;
    private Double price;
	
}
