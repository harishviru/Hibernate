package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Address;
import com.har.entity.AddressAnno;
import com.har.entity.Employee;
import com.har.entity.EmployeeAnno;
import com.har.utility.HibernateUtil;

//Component Mapping by Using <component> tag and @Embeddable ,@Embedded
public class ComponentMappingClientTest {


	public static void main(String[] args) {
		//componentMappingXmlTest();
		componentMappingAnnoTest();
	 }

	private static void componentMappingXmlTest() {
		   Employee   emp                 = null;	
		   Address addrs                    = null;
		
		           //get session object
		     try (Session     session        = HibernateUtil.getSession()) {
		    	 Transaction  txn        = null;
		    	 
		    	 emp   = new Employee();
		    	 emp.setEmpName("Jay");
		    	 emp.setDesignation("Lead");
		    	 emp.setSalary(200000.0);

		    	 //Create Addrs object
		    	 addrs =new Address();
		    	 addrs.setHouseNo("7/666");
		    	 addrs.setStreet("Madhapur");
		    	 addrs.setState("TS");
		    	 addrs.setCity("Hyderabad");
		    	 //add address obj in emp
		    	 emp.setAddress(addrs);
		    	 
		    	 txn =session.beginTransaction();
		    	 
		    	 //save object
		    	 Integer id = (Integer) session.save(emp);
		    	 System.out.println("Successfully saved employee obj as Id ::"+id);
		    	 
		    	 txn.commit();
		     } catch (Exception e) {
					e.printStackTrace();
				} finally {
						HibernateUtil.closeSessionFactory();
				}
	}
	
	private static void componentMappingAnnoTest() {
		   EmployeeAnno   emp        = null;	
		   AddressAnno addrs                    = null;
		
		           //get session object
		     try (Session     session        = HibernateUtil.getSession()) {
		    	 Transaction  txn        = null;
		    	 
		    	 emp   = new EmployeeAnno();
		    	 emp.setEmpName("Murthy");
		    	 emp.setDesignation("Lead");
		    	 emp.setSalary(500000.0);

		    	 //Create Addrs object
		    	 addrs =new AddressAnno();
		    	 addrs.setHouseNo("7/896");
		    	 addrs.setStreet("Jubilee Hills");
		    	 addrs.setState("TS");
		    	 addrs.setCity("Hyderabad");
		    	 //add address obj in emp
		    	 emp.setAddress(addrs);
		    	 
		    	 txn =session.beginTransaction();
		    	 
		    	 //save object
		    	 Integer id = (Integer) session.save(emp);
		    	 System.out.println("Successfully saved employee obj as Id ::"+id);
		    	 
		    	 txn.commit();
		     } catch (Exception e) {
					e.printStackTrace();
				} finally {
						HibernateUtil.closeSessionFactory();
				}
	}
	
}
