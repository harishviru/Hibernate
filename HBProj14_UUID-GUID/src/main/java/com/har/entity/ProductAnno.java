package com.har.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

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

	//Default Developer must have to supply id value
	/* @Id
	 @Column(name="product_id")
	private Integer prodId;*/
	 
	 
	//GenerationType.AUTO
	/* @Id
	 @GeneratedValue                    // ==== equal ==@GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="product_id")
	private Integer prodId;*/
	 
	 
	// GenerationType.IDENTITY
	/* @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)                 
	 @Column(name="product_id")
	private Integer prodId;*/
	
	
	  //#01 :GenerationType.SEQUENCE    
	//Actually SEQUENECE Works in Oracle but  not in MYSQL ,becoz Hibernate uses TABLE SEQUENCE In MYSQL
	///Here Hibernate create default sequence
	/*@Id
	 @GeneratedValue (strategy= GenerationType.SEQUENCE)
	 @Column(name="product_id")
	 private Integer prodId;*/
	
	
	  //#02 :GenerationType.SEQUENCE   
	   //Actually SEQUENECE Works in Oracle but  not in MYSQL ,becoz Hibernate uses TABLE SEQUENCE In MYSQL
	   ///Here We are assigning the our table sequence
	/*	 @Id
		 @GeneratedValue (strategy= GenerationType.SEQUENCE,generator="prodSeqGen")
		@SequenceGenerator(name = "prodSeqGen", sequenceName = "product_sequence")
		 @Column(name="product_id")
		 private Integer prodId;*/
		
	///#01.Here Hibernate create default Table  for Id generation
	/*@Id
	@GeneratedValue (strategy= GenerationType.TABLE)
	@Column(name="product_id")
	private Integer prodId;*/
	
	///#02.Here Hibernate uses assinged Table 
/*	@Id
	@GeneratedValue (strategy= GenerationType.TABLE,generator="prodTableGen")
	@TableGenerator(name = "prodTableGen", table = "product_sequence")
	@Column(name="product_id")
	private Integer prodId;*/
	
	/*@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "product_id", updatable = false, nullable = false)
    private UUID id;*/
	
	@Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(
        name = "GUID",
        strategy = "org.hibernate.id.GUIDGenerator"
    )
    @Column(name = "product_id", updatable = false, nullable = false)
    private String id;
	
	
	 
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private Double prodPrice;

}
