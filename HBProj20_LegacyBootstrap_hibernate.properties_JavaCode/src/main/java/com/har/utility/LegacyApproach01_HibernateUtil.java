package com.har.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.har.entity.Student;

//Legacy Approach #01 :: By using hibernate.properties


//The Utility Class to get Hibernate session management from SessionFactory
public class LegacyApproach01_HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{	    
		 try {
			//Boot strapping the hibernate
			 Configuration cfg      =  new Configuration();
			//Specify mapping file location [xml]
			cfg.addFile("src/main/java/com/har/entity/Student.hbm.xml");
			//cfg.addAnnotatedClass(Student.class);
			
			// create  HB SessionFactory object
			sessionFactory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println("Exception msg           ::"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
	
	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
