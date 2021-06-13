package com.har.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Traveller;
import com.har.entity.TravellerAnno;
import com.har.utility.HibernateUtil;

//CollectionMapping like List,Set,Map <-------><list> or <bag>,<set> ,or <map>
//Collection Mapping like @ElementCollection  ,@CollectionTable,@JoinColumn,@OrderColumn,@MapKeyColumn

public class CollectionMappingTest {

	public static void main(String[] args) {
		//collectionXMLMappingTest();
		collectionAnnoMappingTest();
	}
	
	private static void collectionXMLMappingTest(){
		Traveller     traveller     =null;
		Traveller     traveller2    =null;
		
		try(Session session =HibernateUtil.getSession()) {
			Transaction txn    =null;
			
			//Create Object
			traveller     = new Traveller();
			traveller.setTravellerName("Ramesh");
			//#02
			traveller2     = new Traveller();
			traveller2.setTravellerName("Harish");
			
			//==============For Traveller #01=================================
			//#01 .friends [For <list> tag..........]
			List<String> friends = new ArrayList<>();
			friends.add("Vamsi");
			friends.add("Varun");
			friends.add("Raju");
			friends.add("Priya");
			
			//#02 .friends [For <bag> tag..........]
			List<String> countriesToVisit = new ArrayList<>();
			countriesToVisit.add("Srilanka");
			countriesToVisit.add("Nepal");
			countriesToVisit.add("Bangaladesh");
			countriesToVisit.add("Thailand");

			//#03 .phones   [For <set> tag............]
			Set<Long> phones =new HashSet<>();
			phones.add(1381790424l);
			phones.add(9281408304l);
			phones.add(9900331673l);
			phones.add(21335185928l);
			
			
			//#04.placesVisited [For <map> tag...............]
			Map<String,String> placesVisited =new LinkedHashMap<>();
			placesVisited.put("IndiaTour", "Telangana,Ap,MadhyaPradesh");
			placesVisited.put("Singapure", "Singapure");
			
			
			//==============For Traveller #02=================================
			//#01 .friends [For <list> tag..........]
			List<String> friends2 = new ArrayList<>();
			friends2.add("Raji");
			friends2.add("Somesh");
			friends2.add("Rai");
			friends2.add("Santhosh");
			
			//#02 .friends [For <bag> tag..........]
			List<String> countriesToVisit2 = new ArrayList<>();
			countriesToVisit2.add("England");
			countriesToVisit2.add("Island");
			countriesToVisit2.add("China");
			countriesToVisit2.add("Singapure");

			//#03 .phones   [For <set> tag............]
			Set<Long> phones2 =new HashSet<>();
			phones2.add(91470197401l);
			phones2.add(9009303793l);
			phones2.add(9978231673l);
			phones2.add(21332135928l);
			
			
			//#04.placesVisited [For <map> tag...............]
			Map<String,String> placesVisited2 =new LinkedHashMap<>();
			placesVisited2.put("IndiaTour", "Delhi,Kanyakumari,kashmir");
			placesVisited2.put("AustraliaTour", "Australia");
			
			//set the Collection objects to traveller#01
			traveller.setFriends(friends);
			traveller.setPhones(phones);
			traveller.setCountriesToVisit(countriesToVisit);
			traveller.setPlacesVisited(placesVisited);
			
			//set the Collection objects to traveller#02
			traveller2.setFriends(friends2);
			traveller2.setPhones(phones2);
			traveller2.setCountriesToVisit(countriesToVisit2);
			traveller2.setPlacesVisited(placesVisited2);
			
			
			txn=session.beginTransaction();
			 session.save(traveller);
			 session.save(traveller2);
			txn.commit();
			System.out.println("successfully saved Traveller object.............!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			HibernateUtil.closeSessionFactory();
		}
	}	
	
	private static void collectionAnnoMappingTest(){
		TravellerAnno     traveller     =null;
		TravellerAnno     traveller2    =null;
		
		try(Session session =HibernateUtil.getSession()) {
			Transaction txn    =null;
			
			//Create Object
			traveller     = new TravellerAnno();
			traveller.setTravellerName("Ramesh");
			//#02
			traveller2     = new TravellerAnno();
			traveller2.setTravellerName("Harish");
			
			//==============For Traveller #01=================================
			//#01 .friends [For <list> tag..........]
			List<String> friends = new ArrayList<>();
			friends.add("Vamsi");
			friends.add("Varun");
			friends.add("Raju");
			friends.add("Priya");
			
			//#02 .friends [For <bag> tag..........]
			List<String> countriesToVisit = new ArrayList<>();
			countriesToVisit.add("Srilanka");
			countriesToVisit.add("Nepal");
			countriesToVisit.add("Bangaladesh");
			countriesToVisit.add("Thailand");

			//#03 .phones   [For <set> tag............]
			Set<Long> phones =new HashSet<>();
			phones.add(1381790424l);
			phones.add(9281408304l);
			phones.add(9900331673l);
			phones.add(21335185928l);
			
			
			//#04.placesVisited [For <map> tag...............]
			Map<String,String> placesVisited =new LinkedHashMap<>();
			placesVisited.put("IndiaTour", "Telangana,Ap,MadhyaPradesh");
			placesVisited.put("Singapure", "Singapure");
			
			
			//==============For Traveller #02=================================
			//#01 .friends [For <list> tag..........]
			List<String> friends2 = new ArrayList<>();
			friends2.add("Raji");
			friends2.add("Somesh");
			friends2.add("Rai");
			friends2.add("Santhosh");
			
			//#02 .friends [For <bag> tag..........]
			List<String> countriesToVisit2 = new ArrayList<>();
			countriesToVisit2.add("England");
			countriesToVisit2.add("Island");
			countriesToVisit2.add("China");
			countriesToVisit2.add("Singapure");

			//#03 .phones   [For <set> tag............]
			Set<Long> phones2 =new HashSet<>();
			phones2.add(91470197401l);
			phones2.add(9009303793l);
			phones2.add(9978231673l);
			phones2.add(21332135928l);
			
			
			//#04.placesVisited [For <map> tag...............]
			Map<String,String> placesVisited2 =new LinkedHashMap<>();
			placesVisited2.put("IndiaTour", "Delhi,Kanyakumari,kashmir");
			placesVisited2.put("AustraliaTour", "Australia");
			
			//set the Collection objects to traveller#01
			traveller.setFriends(friends);
			traveller.setPhones(phones);
			traveller.setCountriesToVisit(countriesToVisit);
			traveller.setPlacesVisited(placesVisited);
			
			//set the Collection objects to traveller#02
			traveller2.setFriends(friends2);
			traveller2.setPhones(phones2);
			traveller2.setCountriesToVisit(countriesToVisit2);
			traveller2.setPlacesVisited(placesVisited2);
			
			
			txn=session.beginTransaction();
			 session.save(traveller);
			 session.save(traveller2);
			txn.commit();
			System.out.println("successfully saved Traveller object.............!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close Hibernate SessionFactory
			HibernateUtil.closeSessionFactory();
		}
	}	
	
}
