package com.har.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Traveller {

	private Integer travellerId;
	private String travellerName;
	private List<String> friends;
	private List<String>  countriesToVisit;
	private  Set<Long> phones;
	private  Map<String,String> placesVisited;
	
}
