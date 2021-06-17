========================= many-to-many====================Uni====&===Bi=========

• This type of relation relates many objects of an Entity to many object's of another entity.
• To define a many-to-many relation-ship in the database environment we can use link table


In XML :: (Uni)
        Doctor.hbm.xml
                     <set name="patients"   cascade="all"  lazy="extra">
                             <key column="doctor_id"/>        <!--  Fk association column -->
                             <many-to-many  class="com.har.entity.Patient" column="patient_Id" /> 
                      </set>
                      
         Patient.hbm.xml
                     <class name="com.har.entity.Patient" table="patient">   
                            ..........normal properties.............          
                       </class>
  
  In  XML :: (BI)
               Car.hbm.xml
                     <set name="people" cascade="all" lazy="true" table="person_cars" inverse="true">
                                  <key column="car_id"/>       <!-- FK  -->
                                    <many-to-many  class="com.har.entity.Person" column="person_id"/>
                      </set> 
                      
                 Person.hbm.xml  
                     <set name="cars" cascade="all" lazy="true" table="person_cars">
                              <key column="person_id"/>       <!-- FK  -->
                              <many-to-many  class="com.har.entity.Car" column="car_id"/>
                      </set>     
                    
  In Anno :: (Uni)
                   Doctor.java
                    
                          @ManyToMany(cascade=CascadeType.ALL)
	                      @JoinTable(name="doc_patients",joinColumns={@JoinColumn(name="doctor_Id")},
	                             inverseJoinColumns={@JoinColumn(name="patient_id")}
	                        )
	                       private	Set<Patient> patients;    	  //To build many-to=many
	
	            Patient.java
	                ............normal properties.............
	                
	   In Anno :: (Uni)
	                   Person.java
	                          @ManyToMany(cascade=CascadeType.ALL)	
	                          @JoinTable(name="person_cars_tab",joinColumns={@JoinColumn(name="person_id")},
	                               inverseJoinColumns={@JoinColumn(name="car_id")}
		                     )
		                    private Set<Car> cars;
	                        
	                 Car.java
	                 
	                 	 @ManyToMany(mappedBy="cars")
	                      private Set<Person> people;      //For Build many-to-many association
	                   
	                   
	                   
	                             
	                
	                            
	            
         
                       
                            