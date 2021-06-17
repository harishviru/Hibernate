package com.har.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.domains.Car;
import com.har.domains.Doctor;
import com.har.domains.Patient;
import com.har.domains.Person;
import com.har.utility.HibernateUtil;

public class ManyToManyAnnoTest {

	public static void main(String[] args) {
		//manyToManyUni_DirAnno();
		manyToManyBi_DirAnno();
	}

private static void manyToManyUni_DirAnno(){
		
		try(Session session=HibernateUtil.getSession()){
			
			Doctor doctor =new Doctor();
			doctor.setDoctorName("Vamsi");
			doctor.setDoctorQlf("MBBS");
			doctor.setHospital("Vamsi Hospital");

			Patient patient =new Patient();
			patient.setPatientName("Varun");
			patient.setPatientAddrs("Hyd");
			patient.setProblem("Headache");
			
			Patient patient2 =new Patient();
			patient2.setPatientName("Rahul");
			patient2.setPatientAddrs("Vizag");
			patient2.setProblem("Nickache");
			
			   Set<Patient>  patients=new HashSet<>();
			
			patients.add(patient);
			patients.add(patient2);
			doctor.setPatients(patients);
			
			  Transaction txn =session.beginTransaction();
			  session.save(doctor);
			 txn.commit();
			
			System.out.println("successfully saved.......!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
private static void manyToManyBi_DirAnno(){
	
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
		
		  Set<Car>  cars=new HashSet<>();
		
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
