package com.har.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Book;
import com.har.utility.HibernateUtil;

public class ConnectionPoolWithC3PO_Hikari_Proxool_Test {

	public static void main(String[] args) {
		connectionPoolsTest();
		
	}

	
	
	private static void connectionPoolsTest() {
		Book    book                      = null;
		
		try(Session session =HibernateUtil.getSession()){
			Transaction txn  = null;
			
			txn =session.beginTransaction();
			//Create Book Object
			
			book  = new  Book();
			book.setIsbn(1);
			book.setBookName("Head First Java");
			book.setAuthorName("Kathy");
			book.setCategory("ORM");
			book.setPrice(2000.0);

			//save entity object
			Serializable id = session.save(book);
			
			txn.commit();
			System.out.println("Successfully saved ..........and Id is..."+id);
			
		}catch (Exception e) {
			 e.printStackTrace();
		}finally {
			  //Close SessionFactory
			  HibernateUtil.closeSessionFactory();
		}
	}

	
}
