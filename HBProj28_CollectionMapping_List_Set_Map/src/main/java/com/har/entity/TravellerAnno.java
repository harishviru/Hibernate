package com.har.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="traveller")
public class TravellerAnno {

	@Id
	@GeneratedValue(generator="incrGen")
	@GenericGenerator(name="incrGen",strategy="increment")
	@Column(name="traveller_id",nullable=false,unique=true)
	private Integer travellerId;
	
	@Column(name="traveller_name")
	private String travellerName;
	
	//#01.List Collection
	@ElementCollection                                                                                                           // To Represent Collection
	@CollectionTable(name="traveller_list_friends")                                                      //Table Name of Collection friends name [<list name="friends" table="traveller_list_friends">.
	@JoinColumn(name="traveller_Id") // FK column association  [key column="traveller_Id"/> ..]
	@OrderColumn(name="traveller_index")                                                                    //Index column                  [<index column="traveller_index"...........]
	@Column(name="traveller_friend_name")
	private List<String> friends;
	
	//#02.List/Bag Collection
	@ElementCollection    
	@CollectionTable(name="traveller_bag_countries_to_visit")  
	@JoinColumn(name="traveller_Id") 
	@OrderColumn(name="traveller_index")   
	@Column(name="country_name")
	private List<String>  countriesToVisit;
	
	//#03. Set Collection
	@ElementCollection    
	@CollectionTable(name="traveller_set_phoneNos")   
	@JoinColumn(name="traveller_Id") 
	@Column(name="phone_number")
	private  Set<Long> phones;
	
	
	//#04.Map collection
	@ElementCollection    
	@CollectionTable(name="places_map_visited")   
	@JoinColumn(name="traveller_Id") 
	@MapKeyColumn(name="tour_name",length=20)             //<map-key column="tour_name" l
	@Column(name="tour_place")
	private  Map<String,String> placesVisited;
	
}
