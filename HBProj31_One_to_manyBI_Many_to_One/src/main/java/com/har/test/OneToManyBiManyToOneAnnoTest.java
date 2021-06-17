package com.har.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Owner;
import com.har.entity.Vehicle;
import com.har.utility.HibernateUtil;

public class OneToManyBiManyToOneAnnoTest {

	public static void oneToManyBiManyToOneAnno() {
	 try (Session session=HibernateUtil.getSession()){
			
			Owner owner =new Owner();
			owner.setOwnerName("Harish");
			owner.setOwnerAddrs("Hyd");
			
			Vehicle vehicle1 =new Vehicle();
			vehicle1.setVehicleName("RTU");
			vehicle1.setCompanyName("Mahendra");
			vehicle1.setOwner(owner);
			
			Vehicle vehicle2 =new Vehicle();
			vehicle2.setVehicleName("Car");
			vehicle2.setCompanyName("Benz");
			vehicle2.setOwner(owner);
			
		
			//Prepare Set of child objects
			Set<Vehicle> childs=new HashSet<>();
			childs.add(vehicle1);
			childs.add(vehicle2);
			
			owner.setVehicles(childs);

			Transaction txn =session.beginTransaction();
			session.save(owner);
			txn.commit();
			System.out.println("successfully saved object from (Parent [owner] to child [vehicles])");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
