package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;

/**
 * @author Harish
 *   
 *   i) get ::
 *              		<T> T get(Class<T> entityType, Serializable id);
     ii)load ::
                   	<T> T load(Class<T> theClass, Serializable id);
     iii)saveOrUpdate::
                      	void saveOrUpdate(Object object);       
                      	• If  object is not there in Database it will save else it will update       	
 *
 */
public class saveOrUpdateObjectClientTest {

	/**
	 * saveOrUpdate     :: If  object is not there in Database it will save else it will update    
	 */
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Student   studentUpdate                   = null;

		     //Create student object
		     student    = new Student();
		     student.setFirstName("Durga");
		     student.setLastName("Prasad");
		     student.setMarks(40);
		     student.setGrade("D");
		
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	   Transaction txn = session.beginTransaction();
					//saveOrUpdate the object
					 session.saveOrUpdate(student);
					 txn.commit();
					System.out.println("student is  successfully saved..........");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(session.isOpen()){      //Close Session and SessionFactory
						HibernateUtil.closeSession(session);
						//HibernateUtil.closeSessionFactory();
					}
				}
		      System.out.println("-------------------------------------------------------------------");
		     //get session object
	            session       = HibernateUtil.getSession();
	            
	            try {
	            	 Transaction txn1 = session.beginTransaction();
	            	 //get student object 
	            	studentUpdate=session.get(Student.class, 4);
	            	studentUpdate.setFirstName(studentUpdate.getFirstName()+" - Updated");
	            	studentUpdate.setLastName(studentUpdate.getLastName()+" - Updated");
	            	
					//saveOrUpdate the object
					 session.saveOrUpdate(studentUpdate);
					 
					 txn1.commit();
					System.out.println("student is  successfully updated.........."+studentUpdate);
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
