package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;


public class SaveObjectClientTest {


	public static void main(String[] args) {
		
		Session           session                           = null;
		Transaction     txn                                 =null;
		Student   student                                 = null;
		Boolean   falg                                        = false;
		
		
		           //get session object
		            session       = HibernateUtil.getSession();
				//Create Domain Object
				   student     = new Student();
				   student.setFirstName("Sri");
				   student.setLastName("Lakshmi");
				   student.setMarks(60);
				   student.setGrade("C");
				
				try {
					//Begin transaction
					txn =session.beginTransaction();
					
					//Save the object
					Integer id = (Integer) session.save(student);
					txn.commit();
					falg =true;
					System.out.println("Successfully saved object with Id ::"+id);
				} catch (Exception e) {
					e.printStackTrace();
					falg =false;
					if(!falg && session.isOpen()){
						txn.rollback();
					}
				} finally {
					if(falg && session.isOpen()){      //Close Session and SessionFactory
						HibernateUtil.closeSession(session);
						HibernateUtil.closeSessionFactory();
					}
					if(!falg && session.isOpen()){
						txn.rollback();
					}
				}
	 }
}
