package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Department;
import com.har.entity.Employee;
import com.har.utility.HibernateUtil;

public class ManyToOneTest {

	public static void main(String[] args) {
		//manyToOneXML();
		manyToOneAnno();
	}
	
	private static void manyToOneXML(){
		try(Session session=HibernateUtil.getSession()){
			
			//Create entity objects
			Department dep=new Department();
			dep.setDname("IT");
			dep.setLocation("Hyd");
			
			Employee emp1=new Employee(); //Child to parent (many-to-one)
			emp1.setDepartment(dep);
			emp1.setEmpName("Harish");
			emp1.setSalary(40000.0);
			
			Employee emp2=new Employee();
			emp2.setDepartment(dep);
			emp2.setEmpName("Arjun");
			emp2.setSalary(25000.0);

			Transaction txn =session.beginTransaction();
			session.save(emp1);
			session.save(emp2);
			txn.commit();
			System.out.println("Successfully saved object (child to parent)");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			HibernateUtil.closeSessionFactory();
		}
	}
	
	private static void manyToOneAnno(){
		try(Session session=HibernateUtil.getSession()){
			
			//Create entity objects
			com.har.domain.Department dep=new com.har.domain.Department();
			dep.setDname("IT");
			dep.setLocation("Hyd");
			
			com.har.domain.Employee emp1=new com.har.domain.Employee(); //Child to parent (many-to-one)
			emp1.setDepartment(dep);
			emp1.setEmpName("Harish");
			emp1.setSalary(40000.0);
			
			com.har.domain.Employee emp2=new com.har.domain.Employee();
			emp2.setDepartment(dep);
			emp2.setEmpName("Arjun");
			emp2.setSalary(25000.0);

			Transaction txn =session.beginTransaction();
			session.save(emp1);
			session.save(emp2);
			txn.commit();
			System.out.println("Successfully saved object (child to parent)");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			HibernateUtil.closeSessionFactory();
		}
	}
}
