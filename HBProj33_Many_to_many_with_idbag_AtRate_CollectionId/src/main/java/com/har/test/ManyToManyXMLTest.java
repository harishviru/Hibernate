package com.har.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Car;
import com.har.entity.Person;
import com.har.utility.HibernateUtil;

public class ManyToManyXMLTest {

	public static void main(String[] args) {
		manyToManyBi_Idbag_XML();	
	}
	
	
	private static void manyToManyBi_Idbag_XML(){
		
		try(Session session=HibernateUtil.getSession()){
			
			Person person =new Person();
			person.setFirstName("Harish");
			person.setLastName("Viru");
			
			Car car1=new Car();
			car1.setCarName("Tata XYZ");
			car1.setModal("TATA");
			
			Car car2=new Car();
			car2.setCarName("Benz  ABC");
			car2.setModal("Benz");
			
			  List<Car>  cars=new ArrayList<>();
			
			  cars.add(car1);
			  cars.add(car2);
			  person.setCars(cars);
			
			  Transaction txn =session.beginTransaction();
			  session.save(person);
			 txn.commit();
			System.out.println("successfully saved.......!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
