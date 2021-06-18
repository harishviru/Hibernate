 =============Many-to-many---=====collection-id with_idbag===OR==@CollectionId========
 
 
 In XML ::
                    Person.hbm.xml 
                               <!--Bi-directional  with idbag with collection-id-->
                                    <idbag name="cars" cascade="all" lazy="true" table="person_cars">
                                          <collection-id type="int" column="col_index">
                                             <generator class="increment"/> 
                                         </collection-id>
                                        <key column="person_id"/>       <!-- FK  -->
                                      <many-to-many  class="com.har.entity.Car" column="car_id"/>
                                   </idbag>
                                   
                               Car.hbm.xml
                                                   <!--Bi-directional  -->
                                   <set name="people" cascade="all" lazy="true" table="person_cars" inverse="true">
                                       <key column="car_id"/>       <!-- FK  -->
                                        <many-to-many  class="com.har.entity.Person" column="person_id"/>
                                    </set>            
 
 In Anno ::
                 Person.java
                        //Bi-directional :: With custom Table name as "person_cars_tab"
	                     @ManyToMany(cascade=CascadeType.ALL)	
                   	    @JoinTable(name="person_cars_tab",joinColumns={@JoinColumn(name="person_id",referencedColumnName="person_Id")},
	                               inverseJoinColumns={@JoinColumn(name="car_id",referencedColumnName="car_Id")}
		                 )
	                     @GenericGenerator(name="gen1", strategy = "increment")
	                     @CollectionId(columns=@Column(name="col_index"),
	                                      generator="gen1",type=@Type(type="int")
	                       )
		                 private List<Car> cars;
                 
                          Car.java
      
	                        @ManyToMany(mappedBy="cars")
	                        private Set<Person> people;      //For Build many-to-many association            
                 
                 
                 
 
 