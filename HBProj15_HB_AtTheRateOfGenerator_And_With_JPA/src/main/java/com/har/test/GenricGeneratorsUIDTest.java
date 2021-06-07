package com.har.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.ProductAnno;
import com.har.utility.HibernateUtil;


public class  GenricGeneratorsUIDTest {

	public static void main(String[] args) {
		createAnnoGeneratorsTest();
	}

	
	private static void createAnnoGeneratorsTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Boolean flag                        = false;
		ProductAnno product               = null;
		  try {
			 //
			  product = new ProductAnno();
			  product.setProdPrice(180.0);
			  product.setProductName("Sunfolwer oil");
			  
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			   txn=session.beginTransaction();			
			   Serializable  Id= session.save(product);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully saved product object with id   ::"+Id);
			   
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
