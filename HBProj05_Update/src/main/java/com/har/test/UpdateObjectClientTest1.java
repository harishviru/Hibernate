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
public class UpdateObjectClientTest1 {

	
	/**
	 *  
	 * ii)Update the object by manually setting  existing Pk  key in DB
	 */
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Transaction     txn                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	  student= new Student();
		    	  student.setStudentId(6);  //Must be exist in Database
		    	  student.setFirstName("Rajesh");
		    	  student.setLastName("Kumar");
		    	  student.setMarks(45);
		    	  student.setGrade("D");

		    	  txn =session.beginTransaction();		    	  
		    	  //update object
		    	   session.update(student);
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
