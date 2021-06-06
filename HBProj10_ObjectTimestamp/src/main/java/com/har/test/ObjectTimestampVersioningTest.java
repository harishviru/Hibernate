package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.CallerTune;
import com.har.utility.HibernateUtil;

public class ObjectTimestampVersioningTest {

	public static void main(String[] args) {
		
		//SaveObjectTimestampTest();	
		 updateObjectTimestampTest();
	}

	/**
	 *  #SaveObjectTimestampTest
	 */
	private static void SaveObjectTimestampTest() {
		Session       session              = null;
		Transaction     txn                = null;
		CallerTune  callerTune        = null;
		Boolean flag                        = false;
		
		  try {
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			
			   callerTune = new CallerTune();
			   callerTune.setCallerTune("KGF");
			   callerTune.setProvider("jio");
			   callerTune.setMobile(9900778823L);
			   
			   txn=session.beginTransaction();			
			   Integer id = (Integer) session.save(callerTune);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully saved object with id   ::"+id);
		} catch (Exception e) {
			e.printStackTrace();
			 if(!flag){
				 txn.rollback();
			 }
		}finally {
			    if(flag && session.isOpen()){             // Close Session and SessionFactory
			    	HibernateUtil.closeSession(session);
			    	HibernateUtil.closeSessionFactory();
			    }
		}
	}
	/**
	 * #updateObjectTimestampTest
	 */
	private static void updateObjectTimestampTest() {
		Session       session              = null;
		Transaction     txn                = null;
		CallerTune  callerTune        = null;
		Boolean flag                        = false;
		
		  try {
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			
			   callerTune =session.get(CallerTune.class, 1);
			   callerTune.setProvider("BSNL");
			   
			   txn=session.beginTransaction();			
			    session.update(callerTune);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully updated CallerTune object");
		} catch (Exception e) {
			e.printStackTrace();
			 if(!flag){
				 txn.rollback();
			 }
		}finally {
			    if(flag && session.isOpen()){             // Close Session and SessionFactory
			    	HibernateUtil.closeSession(session);
			    	HibernateUtil.closeSessionFactory();
			    }
		}
	}
}
