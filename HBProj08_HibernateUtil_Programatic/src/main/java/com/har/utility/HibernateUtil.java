package com.har.utility;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

//The Utility Class to get Hibernate session management from SessionFactory (Programatically)
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{	    
		 try {
			//Boot strapping the hibernate
			 Configuration cfg      =  new Configuration();
			 Properties properties =new Properties();	
			 //Hibernate DBconnection properties
			 properties.setProperty(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");
			 properties.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/HBWalk");
			 properties.setProperty(AvailableSettings.USER, "root");
			 properties.setProperty(AvailableSettings.PASS, "root");
			 properties.setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			 
			 //Hibernate Properties
			 properties.setProperty(AvailableSettings.SHOW_SQL,"true");
			 properties.setProperty(AvailableSettings.FORMAT_SQL,"true");
            properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
            
			 cfg.setProperties(properties);
			 
			 //mapping file
			 cfg.addResource("/com/har/entity/Student.hbm.xml");
			 
			 
			//Specify the name and location of HB cfg file (indirectly  mapping file )
			//cfg.configure("/com/har/cfgs/hibernate.cfg.xml");
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
