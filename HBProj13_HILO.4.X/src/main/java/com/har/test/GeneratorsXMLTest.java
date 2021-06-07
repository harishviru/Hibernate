package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Product;
import com.har.utility.HibernateUtil;


public class GeneratorsXMLTest {

	public static void main(String[] args) {
		//createXMLGeneratorsTest();	
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
			  
		
			  /*<generator class="hilo"/>  Hibernate 4.x-->
               HB uses formula is ::  max_lo*next_hi+next_hi  [next_hi is column name ]       
               10*1+1=11,10*2+2=22,10*3+3=33..........etc */
			  product = new Product();   /// For hilo generator 
			  product.setProductName("IO M3");
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
	

	
}
