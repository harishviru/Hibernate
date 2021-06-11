Inheritance Mapping
----------------------------------
• Hibernate supports three different approaches of inheritance hierarchy mapping.
                          i)Table Per Class Hierarchy   [TPCH]
                          ii)Table Per Subclass                 [TPSC]
                          iii)Table Per Concrete Class     [TPCC] 

  #i)Table Per Class Hierarchy   [TPCH]
-----------------------------------------------------
  • In this approach all the hibernate persistence classes of inheritance will use single database table to store and manage their data by        using extra column (known as discriminator column) is created in table to identity the class.

•In these approach database table column have special column called discriminator column and this column contains some logical             names  which indicates each record in table is inserted by using specific Hibernate persistent class of Inheritance Hierarchy.

•<discriminator> tag  is used to define the discriminator column.
• <subclass>  tag is used to define the sub-class

•  @Inheritance(strategy=InheritanceType.SINGLE_TABLE)   
    @DiscriminatorColumn(name="person_type",discriminatorType=DiscriminatorType.STRING) //equal to   <discriminator> tag
    @DiscriminatorValue("PERSON_ANNO")                            // equal === discriminator-value="PERSON"
    @Polymorphism(type=PolymorphismType.EXPLICIT)   // equal to== polymorphism="explicit"


Note :: In XML we can use Table per class but in annotation we can use strategy=InheritanceType.SINGLE_TABLE

##Predefined Class  ::InheritanceType
---------------------------------------------------
public enum InheritanceType { 
    SINGLE_TABLE,        //A single table per class hierarchy

    TABLE_PER_CLASS,  //A table per concrete entity class.
    /** 
     * A strategy in which fields that are specific to a 
     * subclass are mapped to a separate table than the fields 
     * that are common to the parent class, and a join is 
     * performed to instantiate the subclass.
     */
    JOINED 
}

  Ex :
         In XML :
         -----------
 • <hibernate-mapping>
    <class name="com.har.entity.Person" table="person_tab" discriminator-value="PERSON"  polymorphism="explicit">
                  <id>.........column </id>       
           <!--  Discriminator column to divided record/object type in DB-->
         <discriminator  column="person_type" type="string"/>
          <!-- subclass #01 -->
         <subclass  name="com.har.entity.Employee"  discriminator-value="EMPLOYEE">
               ...............Properties...
         </subclass>
          <!-- subclass #02 -->
         <subclass  name="com.har.entity.ContractEmployee"  discriminator-value="CONTRACT_EMPLOYEE">
                          ..................Properties............
         </subclass>
         </class> 
 </hibernate-mapping>

         In Anno
        ------------

  In Parent Class ::

 •  @Inheritance(strategy=InheritanceType.SINGLE_TABLE)   
     @DiscriminatorColumn(name="person_type",discriminatorType=DiscriminatorType.STRING) //equal to   <discriminator> tag
     @DiscriminatorValue("PERSON_ANNO")                            // equal === discriminator-value="PERSON"
     @Polymorphism(type=PolymorphismType.EXPLICIT)   // equal to== polymorphism="explicit"                                            
                                                
  In Child#01 ::
  
 • @Entity
     @DiscriminatorValue(value="EMPLOYEE_ANNO")
                                   
 In Child#02 ::
  
 • @Entity
     @DiscriminatorValue(value="CONTRACT_EMPLOYEE_ANNO")

output ::
  Hibernate: 
    create table person_tab (
       person_id integer not null,
        person_type varchar(255) not null,
        personName varchar(255),
        designation varchar(255),
        address varchar(255),
        salary double precision,
        location varchar(255),
        contract_period float,
        primary key (person_id)
    ) engine=MyISAM
Hibernate: 
    select
        max(person_id) 
    from
        person_tab
Hibernate: 
    insert 
    into
        person_tab
        (personName, person_type, person_id) 
    values
        (?, 'PERSON', ?)
Hibernate: 
    insert 
    into
        person_tab
        (personName, designation, address, salary, person_type, person_id) 
    values
        (?, ?, ?, ?, 'EMPLOYEE', ?)
Hibernate: 
    insert 
    into
        person_tab
        (personName, location, contract_period, person_type, person_id) 
    values
        (?, ?, ?, 'CONTRACT_EMPLOYEE', ?)
Successfully saved Person Object.......!