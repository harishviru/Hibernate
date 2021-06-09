package com.har.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.har.cust.service.ApacheDBCP2ConnectionProviderService;

//# Custom service with ApacheDBCP2ConnectionProviderService
//builder.addService(ConnectionProvider.class, new ApacheDBCP2ConnectionProviderService());

//The Utility Class to get Hibernate session management from SessionFactory
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{	    
		 try {
			//Boot strapping the hibernate
			 Configuration cfg      =  new Configuration();
		
			 //get RegistryBuilder
			 StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			 
			//add service registry through Service Registry builder
			 builder.addService(ConnectionProvider.class, new ApacheDBCP2ConnectionProviderService());
			 
			 //get starndard registry
			 StandardServiceRegistry registry = builder.configure("com/har/cfgs/hibernate.cfg.xml").build();
			 
			//create SEssionFactory with SErviceRegistry
			sessionFactory = cfg.buildSessionFactory(registry);
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
