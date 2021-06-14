package com.har.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Address;
import com.har.entity.BankAccount;
import com.har.entity.Country;
import com.har.entity.Person;
import com.har.entity.Vehicle;
import com.har.utility.HibernateUtil;

public class OneToManyUniTest {

	public static void main(String[] args) {
		//onetoManyXMLTest();
		onetoManAnnoTest();
	}
	
	private static void onetoManyXMLTest(){
		
		Person person          =null;
		
		try (Session session=HibernateUtil.getSession()){
			
			person  = new Person();
			person.setPersonName("Harish Viru");
			
			//Create #01 .<list> tag ::addressList
			Address  address01 =new Address();
			address01.setStreet("ABC");
			address01.setCity("Hyd");
			address01.setState("TS");
			
			Address  address02 =new Address();
			address02.setStreet("xyz");
			address02.setCity("Amaravthi");
			address02.setState("AP");
			
			List<Address> addressList =new ArrayList();
			addressList.add(address01);
			addressList.add(address02);

			person.setAddressList(addressList);
			
			//Create #02 .<bag< tag        ::vehicleList
			Vehicle vehicle01 =new Vehicle();
			vehicle01.setVehicleOwnerName("Harish");
			vehicle01.setVehicleType("Four Wheeler");
			
			Vehicle vehicle02 =new Vehicle();
			vehicle02.setVehicleOwnerName("Father");
			vehicle02.setVehicleType("Two Wheeler");
			
			List<Vehicle> vehicleList =new ArrayList();
			vehicleList.add(vehicle01);
			vehicleList.add(vehicle02);
			
			person.setVehicleList(vehicleList);
			
			//#03 <set>tag  bankAccountSet
			 BankAccount account01 =new BankAccount();
			 account01.setAccountNumber(97379812981l);
			 account01.setAccountType("Saving");
			 account01.setBalance(4000.0);
			 
			 BankAccount account02 =new BankAccount();
			 account02.setAccountNumber(32768221144l);
			 account02.setAccountType("Current");
			 account02.setBalance(90000.0);
			
				Set<BankAccount> bankAccountSet =new HashSet();
				bankAccountSet.add(account01);
				bankAccountSet.add(account02);
				
				person.setBankAccountSet(bankAccountSet);
			 
			 
				//#04.<map> tag      ::placedVistedMap
				Country country01 =new Country();
				country01.setCountryName("India");
				
				Country country02 =new Country();
				country02.setCountryName("UK");
				
				Map<String,Country> placedVistedMap =new HashMap();
				placedVistedMap.put("IndiaTour", country01);
				placedVistedMap.put("UKTour", country02);

				person.setPlacedVistedMap(placedVistedMap);
				
				Transaction txn =session.beginTransaction();
				session.save(person);
				txn.commit();
				System.out.println("successfully saved .............Object");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			 HibernateUtil.closeSessionFactory();
		}
	}
	
private static void onetoManAnnoTest(){
		
		com.har.domain.Person person          =null;
		
		try (Session session=HibernateUtil.getSession()){
			
			person  = new com.har.domain.Person();
			person.setPersonName("Harish Viru");
			
			//Create #01 .<list> tag ::addressList
			com.har.domain.Address  address01 =new com.har.domain.Address();
			address01.setStreet("ABC");
			address01.setCity("Hyd");
			address01.setState("TS");
			
			com.har.domain.Address  address02 =new com.har.domain.Address();
			address02.setStreet("xyz");
			address02.setCity("Amaravthi");
			address02.setState("AP");
			
			List<com.har.domain.Address> addressList =new ArrayList();
			addressList.add(address01);
			addressList.add(address02);

			person.setAddressList(addressList);
			
			//Create #02 .<bag< tag        ::vehicleList
			com.har.domain.Vehicle vehicle01 =new com.har.domain.Vehicle();
			vehicle01.setVehicleOwnerName("Harish");
			vehicle01.setVehicleType("Four Wheeler");
			
			com.har.domain.Vehicle vehicle02 =new com.har.domain.Vehicle();
			vehicle02.setVehicleOwnerName("Father");
			vehicle02.setVehicleType("Two Wheeler");
			
			List<com.har.domain.Vehicle> vehicleList =new ArrayList();
			vehicleList.add(vehicle01);
			vehicleList.add(vehicle02);
			
			person.setVehicleList(vehicleList);
			
			//#03 <set>tag  bankAccountSet
			com.har.domain.BankAccount account01 =new com.har.domain.BankAccount();
			 account01.setAccountNumber(97379812981l);
			 account01.setAccountType("Saving");
			 account01.setBalance(4000.0);
			 
			 com.har.domain.BankAccount account02 =new com.har.domain.BankAccount();
			 account02.setAccountNumber(32768221144l);
			 account02.setAccountType("Current");
			 account02.setBalance(90000.0);
			
				Set<com.har.domain.BankAccount> bankAccountSet =new HashSet();
				bankAccountSet.add(account01);
				bankAccountSet.add(account02);
				
				person.setBankAccountSet(bankAccountSet);
			 
			 
				//#04.<map> tag      ::placedVistedMap
				com.har.domain.Country country01 =new com.har.domain.Country();
				country01.setCountryName("India");
				
				com.har.domain.Country country02 =new com.har.domain.Country();
				country02.setCountryName("UK");
				
				Map<String,com.har.domain.Country> placedVistedMap =new HashMap();
				placedVistedMap.put("IndiaTour", country01);
				placedVistedMap.put("UKTour", country02);

				person.setPlacedVistedMap(placedVistedMap);
				
				Transaction txn =session.beginTransaction();
				session.save(person);
				txn.commit();
				System.out.println("successfully saved .............Object");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			 HibernateUtil.closeSessionFactory();
		}
	}
	
}
