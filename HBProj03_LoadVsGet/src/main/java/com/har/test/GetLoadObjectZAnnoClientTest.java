package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.entity.StudentAnno;
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
//Annotation based Application
public class GetLoadObjectZAnnoClientTest {


	public static void main(String[] args) {
		Session           session                                    = null;
		StudentAnno   studentFrmLoad                 = null;	
		StudentAnno   studentFrmGet                    = null;		

		
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
					//Load the object
					studentFrmLoad = (StudentAnno) session.load(StudentAnno.class, 2);
					System.out.println("student obj is still not loaded............!");
					System.out.println();
					System.out.println("Load student data  ::"+studentFrmLoad);
					System.out.println("student obj is  loaded............!");
					System.out.println();
					
					//Get the object

					studentFrmGet = (StudentAnno) session.load(StudentAnno.class, 5);
					System.out.println();
					System.out.println("GET student data  ::"+studentFrmGet);					
					
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
