package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.ContractEmployee;
import com.har.entity.ContractEmployeeAnno;
import com.har.entity.Employee;
import com.har.entity.EmployeeAnno;
import com.har.entity.Person;
import com.har.entity.PersonAnno;
import com.har.utility.HibernateUtil;

//#02 ::TablePerConcreteClass [TPCC] 
//Inheritacne Mapping by Using  <union-subclass> tag , 
//                                                                 [@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) ,@AttributeOverrides , @AttributeOverride  .....]
public class InheritaceTPCCMappingClientTest {


	public static void main(String[] args) {
		//inheritanceMappingXMTest();
		inheritanceMappingAnnoTest();
	 }

	private static void inheritanceMappingXMTest() {
		         Person      person                =null;
		         Employee employee           =null;
		         ContractEmployee cEmp  = null;
		           //get session object
		     try (Session     session        = HibernateUtil.getSession()) {
		    	 Transaction     txn     =null;
		    	 
		    	 person         =new Person();
		    	 employee    = new Employee("Lead",128000.0,"Signapore");
		    	 cEmp            = new ContractEmployee("Signapore", 1.5f);
		    	 //Prepare Objects
		    	 person.setPersonName("Harish Viru");
		    	 
		    	 txn =session.beginTransaction();
		    	 //save objects
		    	 session.save(person);
		    	 session.save(employee);
		    	 session.save(cEmp);
		    	 
		    	 txn.commit();
		    	 System.out.println("Successfully saved Person Object.......!");
		     } catch (Exception e) {
					e.printStackTrace();
				} finally {
						HibernateUtil.closeSessionFactory();
				}
	}
	private static void inheritanceMappingAnnoTest() {
		PersonAnno      person              = null;
        EmployeeAnno employee           =null;
        ContractEmployeeAnno cEmp  = null;
          //get session object
    try (Session     session        = HibernateUtil.getSession()) {
   	 Transaction     txn     =null;
   	 
      person         = new PersonAnno();
   	  employee    = new EmployeeAnno("Senior Software Engg",90000.0,"Vizag");
   	  person.setPersonName("Mahesh");
   	  cEmp            = new ContractEmployeeAnno("Vizag", 2.5f);
   	 //Prepare Objects
   	 txn =session.beginTransaction();
   	 //save objects
   	 session.save(person);
   	 session.save(employee);
   	 session.save(cEmp);
   	 
   	 txn.commit();
   	 System.out.println("Successfully saved Person Object.......!");
    } catch (Exception e) {
			e.printStackTrace();
		} finally {
				HibernateUtil.closeSessionFactory();
		}
}
}
