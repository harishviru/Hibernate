package com.har.test;

import org.hibernate.Session;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;


public class ModernApproachsWithCustomServiceAPDBCPClientTest {

	public static void main(String[] args) {
		ModernApproachsWithCustomService();
		
	 }

	private static void ModernApproachsWithCustomService() {
		Session           session                           = null;
		Student   student                                 = null;
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	  student=session.get(Student.class, 4);
		           System.out.println("Student      ::"+student);
		           
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
