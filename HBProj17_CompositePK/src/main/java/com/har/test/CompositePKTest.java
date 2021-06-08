package com.har.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Book;
import com.har.entity.BookAnno01;
import com.har.entity.BookAnno02;
import com.har.ids.BookAnnoComPk02;
import com.har.ids.CompositePK;
import com.har.utility.HibernateUtil;

public class CompositePKTest {

	public static void main(String[] args) {
		//compositeXMLTest();
		//With @IdClass
		//compositeWithIdClassTest();
		//With  @Embeddable and    @EmbeddedId
		compositeWithEmbeddableAnnoClassTest();
	}

	private static void compositeXMLTest() {
		Book    book                      = null;
		CompositePK comPk       = null;
		
		try(Session session =HibernateUtil.getSession()){
			Transaction txn  = null;
			
			txn =session.beginTransaction();
			//Create Book Object
			
			////#01 :: Normal Composite PK
			/*book  = new  Book();
			book.setIsbn(1);
			book.setBookName("Head First Java");
			book.setAuthorName("Kathy");
			book.setCategory("ORM");
			book.setPrice(2000.0);*/
			
			//#02 ::  Composite PK as seperate class
			book  = new  Book();
			comPk = new CompositePK();
			comPk.setIsbn(200);
			comPk.setBookName("Head First Java");
			book.setCompk(comPk);
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
	
	private static void compositeWithIdClassTest() {
		BookAnno01    book         = null;
		
		try(Session session =HibernateUtil.getSession()){
			Transaction txn  = null;
			
			txn =session.beginTransaction();
			//Create Book Object
		
			book = new BookAnno01();
			book.setIsbn(200);
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
	private static void compositeWithEmbeddableAnnoClassTest() {
		BookAnno02    book         = null;
		
		try(Session session =HibernateUtil.getSession()){
			Transaction txn  = null;
			BookAnnoComPk02 comPk02 =null;
			
			txn =session.beginTransaction();
			//Create Book Object
		
			book        = new BookAnno02();
			comPk02 =new BookAnnoComPk02();
			comPk02.setIsbn(200);
			comPk02.setBookName("Head First Java");
			book.setComPk(comPk02);
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
