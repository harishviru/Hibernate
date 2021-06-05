package com.har.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.har.entity.Student;
import com.har.entity.StudentAnno;

/**
 * @author Harish
 *   
 *   i) Save ::
 *              	Serializable save(Object object);
     ii)persist ::
                   	void persist(Object object);
 *
 */
//Annotation based Application
public class SaveObjectZAnnoClientTest {


	public static void main(String[] args) {
		
		Configuration cfg                                 =null;
		SessionFactory sessionFactory          =null;
		Session           session                           = null;
		Transaction     txn                                 =null;
		StudentAnno   student                        = null;
		Boolean   falg                                        = false;
		
		
		//Bootstrap the Hibernate  (Activate HB f/w)
		         cfg              = new Configuration();
		//Specify the name and location of HB cfg file (indirectly  mapping file )
				cfg.configure("/com/har/cfgs/hibernate.cfg.xml");
		// create  HB SessionFactory object
				sessionFactory = cfg.buildSessionFactory();
		// Get session from 	sessionFactory
				session                   =sessionFactory.openSession();
				
				//Create Domain Object
				   student     = new StudentAnno();
				   student.setFirstName("balram");
				   student.setLastName("c");
				   student.setMarks(60);
				   student.setGrade("B");
				
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
						session.close();
						sessionFactory.close();
					}
					if(!falg && session.isOpen()){
						txn.rollback();
					}
				}
	 }
}
