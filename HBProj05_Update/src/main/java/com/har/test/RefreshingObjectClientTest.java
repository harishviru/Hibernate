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
public class RefreshingObjectClientTest {

	
	/**
	 *  
	 * i)Refreshing Object , [while getting record,change DB respective record ] //called synchronization b/w in-memory object and DB
	 */
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	 student=session.get(Student.class, 3);
		           System.out.println("before  modify in DB      ::"+student);
		           
		    	  Thread.sleep(40000);  //during this time modify db table data
		    	  
		           session.refresh(student);
		           System.out.println("after  modify in DB      ::"+student);
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
