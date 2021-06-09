package com.har.test;

import org.hibernate.Session;

import com.har.entity.Student;
import com.har.utility.LegacyApproach01_HibernateUtil;
import com.har.utility.LegacyApproach02_HibernateUtil;


public class LeagacyApproachsClientTest {

	public static void main(String[] args) {
		//leagacyApproachHibernatedotProperties();
		leagacyApproachByProgrammaticApproach();
	 }

	private static void leagacyApproachHibernatedotProperties() {
		Session           session                           = null;
		Student   student                                 = null;
		    
		           //get session object
		            session       = LegacyApproach01_HibernateUtil.getSession();
		     try {
		    	  student=session.get(Student.class, 2);
		           System.out.println("Student      ::"+student);
		           
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(session.isOpen()){      //Close Session and SessionFactory
						LegacyApproach01_HibernateUtil.closeSession(session);
						LegacyApproach01_HibernateUtil.closeSessionFactory();
					}
				}
	}
	private static void leagacyApproachByProgrammaticApproach() {
		Session           session                           = null;
		Student   student                                 = null;
		    
		           //get session object
		            session       = LegacyApproach02_HibernateUtil.getSession();
		     try {
		    	  student=session.get(Student.class, 6);
		           System.out.println("Student      ::"+student);
		           
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(session.isOpen()){      //Close Session and SessionFactory
						LegacyApproach02_HibernateUtil.closeSession(session);
						LegacyApproach02_HibernateUtil.closeSessionFactory();
					}
				}
	}
}
