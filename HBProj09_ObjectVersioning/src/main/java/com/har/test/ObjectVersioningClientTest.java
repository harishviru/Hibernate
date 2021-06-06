package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Employee;
import com.har.utility.HibernateUtil;

public class ObjectVersioningClientTest {

	public static void main(String[] args) {
		//saveObjectVersionTest();
		updateObjectVersionTest();
	}

	/**
	 * #saving ObjectVersion
	 */
	private static void saveObjectVersionTest() {
		Session           session                           = null;
		Transaction     txn                                 = null;
		Employee    employee                         = null;
		    
		
		employee       = new Employee();
		employee.setEmpName("Raju");
		employee.setPosition("Junior Software Engg");
		employee.setSalary(25000.0);
		
	try {
		       //get session object
                 session       = HibernateUtil.getSession();
		    	  txn =session.beginTransaction();		    	  
		    	  //save the object
		    	  Integer id = (Integer) session.save(employee);
		    	  System.out.println("successfully saved Emp Object with Id    ::"+id);		    	    
		    	  txn.commit();

		     } catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(session.isOpen()){      //Close Session and SessionFactory
						HibernateUtil.closeSession(session);
						HibernateUtil.closeSessionFactory();
					}
				}
	 }
	
	/**
	 *  # updating Object Version
	 */
	private static void updateObjectVersionTest() {
		Session           session                           = null;
		Transaction     txn                                 = null;
		Employee    employee                         = null;
		    
	try {
		       //get session object
                 session       = HibernateUtil.getSession();
		    	  txn =session.beginTransaction();		    	  
		    	  //save the object
		    	  employee  = session.get(Employee.class, 1);
		    	  System.out.println(" Emp Object  ::"+employee);	
		    	  employee.setEmpName("Vamsi");
		    	  session.update(employee);
		    	  System.out.println(" Emp Object  updated successfully............... ::"+employee);	
		    	  txn.commit();

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
