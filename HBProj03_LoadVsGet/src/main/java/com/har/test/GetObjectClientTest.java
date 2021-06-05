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
 *
 */
public class GetObjectClientTest {


	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;		
		
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
					//get the object
					student = (Student) session.get(Student.class, 1);
					
					System.out.println("student data  ::"+student);
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
