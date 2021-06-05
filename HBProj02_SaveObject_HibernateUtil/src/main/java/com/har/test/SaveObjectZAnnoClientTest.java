package com.har.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.har.entity.Student;
import com.har.entity.StudentAnno;
import com.har.utility.HibernateUtil;

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
		
		Session           session                          = null;
		Transaction     txn                                =null;
		StudentAnno   student                       = null;
		Boolean   falg                                        = false;
		
		
		           //get session object
		            session       = HibernateUtil.getSession();
		            
				//Create Domain Object
				   student     = new StudentAnno();
				   student.setFirstName("Kavitha");
				   student.setLastName("M");
				   student.setMarks(50);
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
