package com.har.factory;

public class ClientTest {

	public static void main(String[] args) {
		 Animal animal    =null;
		 AnimalFactory  factory =null;
		
          //Create AnimalFactory
		   factory       = new AnimalFactory();
		  animal         = factory.getAnimal("Lion");
		 System.out.println(animal.speak());
		 System.out.println();
		 animal         = factory.getAnimal("Duck");
		 System.out.println(animal.speak());

	}

}
