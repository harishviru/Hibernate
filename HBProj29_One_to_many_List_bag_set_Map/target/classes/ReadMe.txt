                      ===========One-to-many====================
  1)one-to-many
  • In this association one entity object exactly mapping with/association with many objects of another entity.
  •A relationship in which each record in one table is linked to multiple records in another table.
  • One-to-many relation can be developed in four ways.
                   i)Set
                  ii)List
                 iii)Bag
                iv)Array
                 v)Map

#List::
---------
            <list name="collection_ref_name" table="table_name">
                          <key column="fk_col_name"/>
                          <list-index column="index_col_name"/>
                          <element column="collection_col_name" ........./>
              </list>   

  • <list> is an indexed collection where the index will also be persisted


#array::
---------
            <array name="collection_ref_name" table="table_name">
                          <key column="fk_col_name"/>
                          <list-index column="index_col_name"/>
                          <element column="collection_col_name" ........./>
              </array>   

  • <array> is an indexed collection where the index will also be persisted . it is java type but not java.util.List

#Bag::
---------
            <bag name="collection_ref_name" table="table_name">
                          <key column="fk_col_name"/>                         
                          <element column="collection_col_name" ........./>
              </bag>   

  • <bag> is an unordered collection where the index will not   persisted


#Set::
---------
            <set name="collection_ref_name" table="table_name">
                          <key column="fk_col_name"/>                         
                          <element column="collection_col_name" ........./>
              </set>   

  • <set> is an unqiue objects incollection 

#Map
--------
• Map stores its entries key/value pairs.An extra column "key"
                           
                            <map name="collection_ref_name" table="table_name">
                                           <key column="fk"/>
                                            <map-key column="key_col_name"..................../>
                                             <element column="map_val_col_name"........../>
                           </map>

Note :: In the above tags ,we insert  inside or child of any collection type <one-to-many  class="Pkg.ClassName"/>

Inverse::
-----------
• Inverse keyword is responsible for managing the insert/update for the foreign key column.
• An Inverse keyword has the boolean value "true/false" .
• The default of this keyword is 'false'

• If the inverse keyword value is false, parent class is responsible for saving/updating the child and it's relationship.
• If the inverse keyword valye is true,an associated subclass is responsible for saving/updaing itself

Note ::
     • An inverse keyword is always used with the one-to-many and many-to-many
     • It doesn't work with many-to-one relationship


#In Anno ::
-----------------
    //#01. List 
	@OneToMany(targetEntity=Address.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	@OrderColumn(name="address_index")    //index colum cfg
	@ListIndexBase(value=1) // // index col base value
	private List<Address> addressList;
	
	//#02. Bag
	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	private List<Vehicle> vehicleList;
	
	//#03 .Set
	@OneToMany(targetEntity=BankAccount.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	private Set<BankAccount> bankAccountSet;
	
	//#04 .Map
	@OneToMany(targetEntity=Country.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="person_Id")
	@MapKeyColumn(name="map_key_index",length=20)
	private Map<String,Country> placedVistedMap;



Output :: Xml
-------------------------
  
Hibernate: 
    
    drop table if exists address
Jun 13, 2021 10:23:35 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@1704f67f] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    drop table if exists bank_account
Hibernate: 
    
    drop table if exists country
Hibernate: 
    
    drop table if exists person
Hibernate: 
    
    drop table if exists vehicle
Hibernate: 
    
    create table address (
       address_id integer not null,
        street varchar(255),
        city varchar(255),
        state varchar(255),
        person_id integer,
        address_index integer,
        primary key (address_id)
    ) engine=MyISAM
Hibernate: 
    
    create table bank_account (
       account_Id integer not null,
        account_type varchar(255),
        account_number bigint,
        balance double precision,
        person_id integer,
        primary key (account_Id)
    ) engine=MyISAM
Hibernate: 
    
    create table country (
       country_Id integer not null,
        country_name varchar(255),
        person_id integer,
        map_key_index varchar(20),
        primary key (country_Id)
    ) engine=MyISAM
Hibernate: 
    
    create table person (
       person_Id integer not null,
        person_name varchar(255),
        primary key (person_Id)
    ) engine=MyISAM
Hibernate: 
    
    create table vehicle (
       vehicle_Id integer not null,
        vehicle_type varchar(255),
        vehicle_owner_name varchar(255),
        person_id integer,
        primary key (vehicle_Id)
    ) engine=MyISAM
Hibernate: 
    
    alter table address 
       add constraint FK81ihijcn1kdfwffke0c0sjqeb 
       foreign key (person_id) 
       references person (person_Id)
Hibernate: 
    
    alter table bank_account 
       add constraint FKi60hm2ci2rknaemf8iy1q5s15 
       foreign key (person_id) 
       references person (person_Id)
Hibernate: 
    
    alter table country 
       add constraint FK5i248bm25uf4g8gu7tfoknxag 
       foreign key (person_id) 
       references person (person_Id)
Hibernate: 
    
    alter table vehicle 
       add constraint FKjqatgcy68lgi0oe1h2jrrhm0 
       foreign key (person_id) 
       references person (person_Id)
Hibernate: 
    select
        max(person_Id) 
    from
        person
Hibernate: 
    select
        max(address_id) 
    from
        address
Hibernate: 
    select
        max(vehicle_Id) 
    from
        vehicle
Hibernate: 
    select
        max(account_Id) 
    from
        bank_account
Hibernate: 
    select
        max(country_Id) 
    from
        country
Hibernate: 
    insert 
    into
        person
        (person_name, person_Id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        address
        (street, city, state, address_id) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        address
        (street, city, state, address_id) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        vehicle
        (vehicle_type, vehicle_owner_name, vehicle_Id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        vehicle
        (vehicle_type, vehicle_owner_name, vehicle_Id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        bank_account
        (account_type, account_number, balance, account_Id) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        bank_account
        (account_type, account_number, balance, account_Id) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        country
        (country_name, country_Id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        country
        (country_name, country_Id) 
    values
        (?, ?)
Hibernate: 
    update
        address 
    set
        person_id=?,
        address_index=? 
    where
        address_id=?
Hibernate: 
    update
        address 
    set
        person_id=?,
        address_index=? 
    where
        address_id=?
Hibernate: 
    update
        vehicle 
    set
        person_id=? 
    where
        vehicle_Id=?
Hibernate: 
    update
        vehicle 
    set
        person_id=? 
    where
        vehicle_Id=?
Hibernate: 
    update
        bank_account 
    set
        person_id=? 
    where
        account_Id=?
Hibernate: 
    update
        bank_account 
    set
        person_id=? 
    where
        account_Id=?
Hibernate: 
    update
        country 
    set
        person_id=?,
        map_key_index=? 
    where
        country_Id=?
Hibernate: 
    update
        country 
    set
        person_id=?,
        map_key_index=? 
    where
        country_Id=?
successfully saved .............Object
  
  
                      
                      
                      
                      
                      
                      