package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;


//Delete Object Test
public class DeleteObjectClientTest {

	//deleting object by  manually setting existing PK key to that object
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Transaction     txn                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	  student= new Student();
		    	  student.setStudentId(3);  //Must be exist in Database
		           System.out.println("student   object...............! ::"+student);
		    	 
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
