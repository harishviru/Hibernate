package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Student;
import com.har.utility.HibernateUtil;

//Case 1 :
/* If object is not associted with session,
 *                                 i)If object/record Id not exist in DB ,then merge() method will insert record.
 *                                 ii) If object/record Id  exist in DB,then merge() method will update record
 */
//Case 2 :
/* If object is  associted with session,
 *                                 i) Then merge() method (object state will merged ) will update record                       
 */

//Merge Object Test
public class MergeObjectClientTest {

	 //Case #1 :: If object is not associted with session,
	//Merge object by  manually setting existing/not existing PK key to that object
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Transaction     txn                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	  student= new Student();
		    	  student.setStudentId(12);  //Must be exist in Database
		    	  student.setFirstName("Mohan");
		    	  student.setLastName("Babu");
		           System.out.println("before student   object merging...............! ::"+student);
		    	 
		    	  txn =session.beginTransaction();		    	  
		    	  //merging object
		    	  student= (Student) session.merge(student);
		    	  txn.commit();
		           System.out.println("after successfully   merged...............! "+student);
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
