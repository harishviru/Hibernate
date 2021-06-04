package com.har.factory;

public class AnimalFactory {

	public Animal getAnimal(String type){
		 Animal animal  =null;
		    if(type.equals("Dog")){
		    	animal =new Dog();
		    }else if(type.equals("Duck")){
		    	animal =new Duck();
		    }else if(type.equals("Lion")){
		    	animal =new Lion();
		    }
		 return animal;
	}
	
}
