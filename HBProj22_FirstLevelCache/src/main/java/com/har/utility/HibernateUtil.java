package com.har.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//The Utility Class to get Hibernate session management from SessionFactory
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{	    
		 try {
			//Boot strapping the hibernate
			 Configuration cfg      =  new Configuration();
			//Specify the name and location of HB cfg file (indirectly  mapping file )
			cfg.configure("/com/har/cfgs/hibernate.cfg.xml");
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
