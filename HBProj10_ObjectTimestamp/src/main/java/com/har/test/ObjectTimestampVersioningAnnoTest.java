package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.CallerTune;
import com.har.entity.Product;
import com.har.utility.HibernateUtil;

/*  
@CreationTimestamp             :: Only In Insert statement
   • When a new entity gets persisted, Hibernate gets the current timestamp from the VM and sets it as the value of the attribute annotated

@UpdateTimestamp              ::Changed with every update statement
   • Hibernate gets the current timestamp from the VM and sets it as the update timestamp on the EVERY SQL Update statement.
      And also used for  new entity to persisting time.

In XML ::
                                                <timestamp name="lastUpdated" column="lastUpdated"/>
 *
 *
 */
public class ObjectTimestampVersioningAnnoTest {

	public static void main(String[] args) {
		
		SaveObjectTimestampTest();	
		 //updateObjectTimestampTest();
	}

	/**
	 *  #SaveObjectTimestampTest
	 */
	private static void SaveObjectTimestampTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Product  product                = null;
		Boolean flag                        = false;
		
		  try {
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			
			   product  = new Product();
			   product.setProductName("Micromax");
			   product.setProdPrice(1000.0);
			   
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
	/**
	 * #updateObjectTimestampTest
	 */
	private static void updateObjectTimestampTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Product  product                = null;
		Boolean flag                        = false;
		
		  try {
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			
			   product =session.get(Product.class, 1);
			   product.setProductName("OPPO Reno 13X");
			   
			   txn=session.beginTransaction();			
			    session.update(product);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully updated product object");
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
