package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;


/*  i)Refreshing Object , [while getting,change DB respective record ]
 *  ii)Update the object  by manually setting  existing Pk  key in DB
 *  iii)Update the object by get record from database
 *  iv)Update the object without invoking session persistent methods [called automatic dirty checking] 
 * 
 */
public class UpdateObjectClientTest3 {

	/**
	 *  
	 * iv)Update the object without invoking session persistent methods [called automatic dirty checking] 
	 */
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Transaction     txn                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	  student= session.get(Student.class, 8);
		           System.out.println("Before  update   ::"+student);
		    	  txn =session.beginTransaction();		    
		    	  student.setFirstName("Saroja");
		    	  student.setLastName("K");
		    	  //Here we are not invoking  session persistent methods 		    	  
		    	  txn.commit();
		           System.out.println("after  update   ::"+student);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(session.isOpen()){      //Close Session and SessionFactory
						HibernateUtil.closeSession(session);
						HibernateUtil.closeSessionFactory();
					}
				}
	 }
}
