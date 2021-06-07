package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Product;
import com.har.entity.ProductAnno;
import com.har.utility.HibernateUtil;


public class GeneratorsXMLAnnoTest {

	public static void main(String[] args) {
		//createXMLGeneratorsTest();	
		createDDLAUTOAnnoTest();
	}


	private static void createXMLGeneratorsTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Boolean flag                        = false;
		Product product                 = null;
		
		  try {
			    //Create product obj
			/*  product = new Product();
			  product.setProdId(30);             /// For assigned generator
			  product.setProductName("MI");
			  product.setProdPrice(16000.0);*/
			  
		/*	  product = new Product();   /// For increment generator
			  product.setProductName("Nokia");
			  product.setProdPrice(1800.0);*/
			  
			  
			  // [Sequence works in Oracle.........! If we use in MYSQL It create default "TABLE" like hibernate_sequence
			 /* product = new Product();   /// For Sequence generator
			  product.setProductName("HP Laptop ");
			  product.setProdPrice(50000.0);*/
			  
			  //Works in MYSQL but in Oracle becoz it supports AUTO INCREMENT.
	/*		  product = new Product();   /// For identity generator
			  product.setProductName("HP Laptop ");
			  product.setProdPrice(50000.0);*/
			  
			  
			/*  product = new Product();   /// For hilo generator not working....H 5.X
			  product.setProductName("Dell Laptop ");
			  product.setProdPrice(80000.0);*/
			  
			/*  product = new Product();   /// For native generator
			  product.setProductName("M Laptop ");
			  product.setProdPrice(9000.0);*/
			  
			  //foreign generator  works on one-to-one relationship
			/*  product = new Product();   /// For foreign generator 
			  product.setProductName("UI");
			  product.setProdPrice(9000.0);
			  */
			  
			  product = new Product();   /// For foreign generator 
			  product.setProductName("Poco M3");
			  product.setProdPrice(9000.0);
			  
			  
			  
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			   txn=session.beginTransaction();			
			   Integer id = (Integer) session.save(product);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully saved product object with id   ::"+id);
			   
		} catch (Exception e) {
			e.printStackTrace();
			 if(!flag){
				 txn.rollback();
			 }
		}finally {
			    if(flag && session.isOpen()){             // Close Session and SessionFactory
			    	HibernateUtil.closeSession(session);
			    	HibernateUtil.closeSessionFactory();
			    }
		}
	}
	
	private static void createDDLAUTOAnnoTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Boolean flag                        = false;
		ProductAnno product        = null;
		
		  try {
			    //Create product obj
			/*  product = new ProductAnno();               // @Id/assigned Generator
			  product.setProdId(4);
			  product.setProductName("Nokia Mobile");
			  product.setProdPrice(1200.0);*/
			  
			  //GenerationType.AUTO
		/*	  product = new ProductAnno();               //@GeneratedValue(strategy=GenerationType.AUTO)
			  product.setProductName("Nokia Mobile");
			  product.setProdPrice(1200.0);*/
			  
			  //GenerationType.IDENTITY
			/*  product = new ProductAnno();               // @GeneratedValue(strategy = GenerationType.IDENTITY)       
			  product.setProductName("Nokia 12 Mobile");
			  product.setProdPrice(1200.0);*/
			  
			  //GenerationType.SEQUENCE             ::Hibernate use TABLE Sequence in MYSQL
		/*	  //GenerationType.SEQUENCE    //Actually SEQUENECE Works in Oracle but  not in MYSQL ,becoz Hibernate uses TABLE SEQUENCE In MYSQL
			  product = new ProductAnno();               // @GeneratedValue(strategy = GenerationType.SEQUENCE)       
			  product.setProductName("Nokia 102 Mobile");
			  product.setProdPrice(1200.0);*/
			  
			  //Here Hibernate create default Table  for Id generation or it uses assigned table for Id generation
			  product = new ProductAnno();               // @GeneratedValue(strategy = GenerationType.TABLE)       
			  product.setProductName("Nokia 102 Mobile");
			  product.setProdPrice(1200.0);
			  
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			   txn=session.beginTransaction();			
			   Integer id = (Integer) session.save(product);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully saved product object with id   ::"+id);
			   
		} catch (Exception e) {
			e.printStackTrace();
			 if(!flag){
				 txn.rollback();
			 }
		}finally {
			    if(flag && session.isOpen()){             // Close Session and SessionFactory
			    	HibernateUtil.closeSession(session);
			    	HibernateUtil.closeSessionFactory();
			    }
		}
	}
	
}
