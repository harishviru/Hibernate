  ==========================================Persistent Class Mapping ===================================
•  Configurations in hibernate mapping file are called as Object Relational mapping configurations
  We can perform the following ORM configurations.......
                                     1)Basic ORM (basic example we can use <property> tag
                                     2)Component Mapping
                                     3)Inheritance Mapping
                                     4)Collection Mapping
                                     5)Association Mapping
                                     
   
   
   4)Collection Mapping::
 -------------------------------
  i)List                                 - <list> or <bag>
 ii)Set                                   - <set>
 iii)Map                              - <map>

//CollectionMapping like List,Set,Map <-------><list> or <bag>,<set> ,or <map>
//Collection Mapping like @ElementCollection  ,@CollectionTable,@JoinColumn,@OrderColumn,@MapKeyColumn

  #i)List   ::
  --------------
      In XML::
     ------------
 <!-- <list> tag     #friends  -->
   <list name="property_name" table="table_name">
               <key column="foreign_key_col_name"/>         <!--FK to assiociation.......!   [ key is used to define the foreign key in this table]-->
                <index column="index_col_name" type="int" length="15"/> 
                <element column="collection_col_name" length="20" type="string"/> 
     </list>

       or 

    <bag name="property_name" table="table_name">
                <key column="foreign_key_col_name"/>                                                  <!--FK to assiociation.......!  ->
               <element column="collection_col_name" length="20" type="string"/> 
   </bag>

   In Anno :
  --------------
	//#01.List Collection
	@ElementCollection                                                                                                           // To Represent Collection
	@CollectionTable(name="traveller_list_friends")                                                      //Table Name of Collection friends name 
	@JoinColumn(name="traveller_Id")                                                                                // FK column association  
	@OrderColumn(name="traveller_index")                                                                    //Index column                
	@Column(name="traveller_friend_name")
	private List<String> friends;



 ii)Set  ::
---------
              In XML ::
              -----------
                <!-- <set> tag    #phones -->
                     <set  name="property_name" table="table_name">
                            <key column="foreign_key_col_name"/>         <!--FK to assiociation.......!   
                            <element column="collection_col_name"type="long" length="12"/>
                     </set>  

             In Anno ::
            -------------
         //#03. Set Collection
	@ElementCollection    
	@CollectionTable(name="traveller_set_phoneNos")   
	@JoinColumn(name="traveller_Id") 
	@Column(name="phone_number")
	private  Set<Long> phones;


iii)map ::
------------
                     In XML::
                     ------------
                  <!-- <map> tag  #placesVisited -->
                     <map  name="property_name" table="table_name">
                            <key column="foreign_key_col_name"/>         <!--FK to assiociation.......!   
                             <map-key column="tour_name" length="20" type="string"/>
                             <element column="tour_place" length="30" type="string"/>
                     </map>

                         In Anno ::
                         -------------

	//#04.Map collection
	@ElementCollection    
	@CollectionTable(name="places_map_visited")   
	@JoinColumn(name="traveller_Id") 
	@MapKeyColumn(name="tour_name",length=20)             //<map-key column="tour_name" l
	@Column(name="tour_place")
	private  Map<String,String> placesVisited;
	
	
	
	output (XML)
	-----------------------
Hibernate: 
    
    create table places_map_visited (
       traveller_Id integer not null,
        tour_name varchar(20) not null,
        tour_place varchar(30),
        primary key (traveller_Id, tour_name)
    ) engine=MyISAM
Hibernate: 
    
    create table traveller (
       traveller_id integer not null,
        traveller_name varchar(255),
        primary key (traveller_id)
    ) engine=MyISAM
Hibernate: 
    
    create table traveller_bag_countries_to_visit (
       traveller_Id integer,
        country_name varchar(20)
    ) engine=MyISAM
Hibernate: 
    
    create table traveller_list_friends (
       traveller_Id integer not null,
        traveller_index integer not null,
        traveller_friend_name varchar(20),
        primary key (traveller_Id, traveller_index)
    ) engine=MyISAM
Hibernate: 
    
    create table traveller_set_phoneNos (
       traveller_Id integer not null,
        phone_number bigint
    ) engine=MyISAM
Hibernate: 
    
    alter table places_map_visited 
       add constraint FKl1npwom2vv9lbfoo7ifgxmq9y 
       foreign key (traveller_Id) 
       references traveller (traveller_id)
Hibernate: 
    
    alter table traveller_bag_countries_to_visit 
       add constraint FKmmje7027snhs30gukq6ecd6jg 
       foreign key (traveller_Id) 
       references traveller (traveller_id)
Hibernate: 
    
    alter table traveller_list_friends 
       add constraint FKltp89snb59p5erod7t00qaf1o 
       foreign key (traveller_Id) 
       references traveller (traveller_id)
Hibernate: 
    
    alter table traveller_set_phoneNos 
       add constraint FKbkaku7xeobpwd4s8i1byskfyl 
       foreign key (traveller_Id) 
       references traveller (traveller_id)
Hibernate: 
    select
        max(traveller_id) 
    from
        traveller
Hibernate: 
    insert 
    into
        traveller
        (traveller_name, traveller_id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller
        (traveller_name, traveller_id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        places_map_visited
        (traveller_Id, tour_name, tour_place) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        places_map_visited
        (traveller_Id, tour_name, tour_place) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_list_friends
        (traveller_Id, traveller_index, traveller_friend_name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_bag_countries_to_visit
        (traveller_Id, country_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        traveller_set_phoneNos
        (traveller_Id, phone_number) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        places_map_visited
        (traveller_Id, tour_name, tour_place) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        places_map_visited
        (traveller_Id, tour_name, tour_place) 
    values
        (?, ?, ?)
successfully saved Traveller object.............!
	
	
                                     