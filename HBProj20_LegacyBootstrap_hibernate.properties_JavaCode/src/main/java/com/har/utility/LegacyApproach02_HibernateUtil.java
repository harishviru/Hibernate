package com.har.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import com.har.entity.Student;

//Legacy Approach #02 :: By adding keys and values to configuration object [By java code]


//The Utility Class to get Hibernate session management from SessionFactory
public class LegacyApproach02_HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{	    
		 try {
			//Boot strapping the hibernate
			 Configuration cfg      =  new Configuration();
			
			 //add connection properties to cfg
			 cfg.setProperty(AvailableSettings.DRIVER,"com.mysql.cj.jdbc.Driver");
			 cfg.setProperty(AvailableSettings.URL,"jdbc:mysql://localhost:3306/HBWalk");
			 cfg.setProperty(AvailableSettings.USER,"root");
			 cfg.setProperty(AvailableSettings.PASS,"root");
			 
			 //hibernate optional props
			 cfg.setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			 cfg.setProperty(AvailableSettings.HBM2DDL_AUTO,"update");
			 cfg.setProperty(AvailableSettings.SHOW_SQL,"true");
			 cfg.setProperty(AvailableSettings.FORMAT_SQL,"true");

			 //add Mapping file
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
