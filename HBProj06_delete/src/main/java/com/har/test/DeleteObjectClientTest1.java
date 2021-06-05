package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;


//Delete Object Test By loading/getting object from database
public class DeleteObjectClientTest1 {

	//Delete Object Test By loading/getting object from database
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Transaction     txn                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	  student=session.get(Student.class, 12);
		           System.out.println("student  object...............! ::"+student);
		    	 
		    	  txn =session.beginTransaction();		    	  
		    	  //deleting object
		    	   session.delete(student);
		    	  txn.commit();
		           System.out.println("successfully   deleted...............! ");
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
