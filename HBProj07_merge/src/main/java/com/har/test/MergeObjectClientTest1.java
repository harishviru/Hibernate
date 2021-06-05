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
*                                 i) Then merge() method (object state will merged) will update record                       
*/

//Merge Object Test
public class MergeObjectClientTest1 {

	//Case #2 :If object is  associted with session,Then merge() method (object state will merged ) will update record    
	public static void main(String[] args) {
		Session           session                           = null;
		Student   student                                 = null;
		Transaction     txn                                 = null;
		    
		           //get session object
		            session       = HibernateUtil.getSession();
		     try {
		    	 txn =session.beginTransaction();		
		    	  //load the student object
		    	  student=session.get(Student.class, 8);  ////collects from DB and keeps first Level cache
		           System.out.println("Loaded student  object...............! ::"+student);
		           
		    	  //update loaded object by creating new object having same id 
		    	   Student student1 =new Student();
		    	   student1.setStudentId(8);                      //object having same id 
		    	   student1.setFirstName("Hari");
		    	   student1.setLastName("sake");
		    	   student1.setMarks(50);
		    	   student1.setGrade("B Grade");
		           
		    	  //updating  object
		    	 // session.update(student1);         //Here we are trying to update object having ID :8 ,
		    	                                                         // but diff object with the same identifier value (8) was already associated with the session,that's why
		    	                                                       // Update thrown expection : org.hibernate.NonUniqueObjectException
		    	   
		    	   session.merge(student1);     //Here when ever  more objects exists with same identifier value (8),then we can use merge method
		    	   
		    	  txn.commit();
		           System.out.println("successfully  merged  ...............! ");
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
