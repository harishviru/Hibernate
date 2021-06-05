package com.har.test;

import org.hibernate.Session;

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
public class LoadObjectClientTest {


	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;		
		
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
					//load the object
					student = (Student) session.load(Student.class, 1);
					System.out.println("student obj is still not loaded............!");
					System.out.println();
					System.out.println("student data  ::"+student);
					System.out.println("student obj is  loaded............!");
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
