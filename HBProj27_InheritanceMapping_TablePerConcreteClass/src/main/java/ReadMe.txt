 =======================================================Persistent Class Mapping ===================================
•  Configurations in hibernate mapping file are called as Object Relational mapping configurations
  We can perform the following ORM configurations.......
                                     1)Basic ORM (basic example we can use <property> tag
                                     2)Component Mapping
                                     3)Inheritance Mapping
                                     4)Collection Mapping
  
 
#03)Inheritance Mapping
----------------------------------
• Hibernate supports three different approaches of inheritance hierarchy mapping.
                          i)Table Per Class Hierarchy   [TPCH]
                          ii)Table Per Subclass                 [TPSC]
                          iii)Table Per Concrete Class     [TPCC]
                          
 
 
 
 #iii)Table Per Concrete Class     [TPCC]  ::
--------------------------------------------------------
 •  In case of Table per concrete class,there will be multiple tables in the database having no relations to each other.
 •    There are two ways to map the table with table per concrete class strategy.

              • By union-subclass element
              • By Self creating the table for each other
 • In xml ,we can use    <union-subclass> tag
 •In Annotation ,we can use @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)   

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) specifies that we are using table per concrete class strategy. It should be specified in the parent class only.

 defines that parent class attributes will be overriden in this class. In table structure, parent class table columns will be added in the subclass table.

Ex ::
            In XML ::
            ------------
          <union-subclass name="pkg.ClassName"  table="table_name">
                                ................Properties......................................
         </union-subclass>
         
         <union-subclass name="pkg.ClassName" table="table_name">
                                    ................Properties......................................
         </union-subclass>

        In Annotation
        --------------------
            Super class ::

            @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)   
             public  class PersonAnno

           Child 1    ::

            @AttributeOverrides({       // Optional 
	     @AttributeOverride(name="personId",column= @Column(name="person_id")),
	     @AttributeOverride(name="personName",column=@Column(name="person_name"))
            })
              public class EmployeeAnno  extends PersonAnno

            Child 2 ::
             
            @AttributeOverrides({       // Optional 
             @AttributeOverride(name="personId",column= @Column(name="person_id")),
             @AttributeOverride(name="personName",column=@Column(name="person_name"))
             })
             public class ContractEmployeeAnno  extends PersonAnno                          
                          
     Output ::
     ---------------
Hibernate: 
    
    create table CONTRACT_EMPLOYEE_JOINED_SUB_02 (
       person_id integer not null,
        person_name varchar(255),
        location varchar(255),
        contract_period float,
        primary key (person_id)
    ) engine=MyISAM
Hibernate: 
    
    create table EMPLOYEE_JOINED_SUB_01 (
       person_id integer not null,
        person_name varchar(255),
        designation varchar(255),
        address varchar(255),
        salary double precision,
        primary key (person_id)
    ) engine=MyISAM
Hibernate: 
    
    create table person_Table_Per_SubClass_tab (
       person_id integer not null,
        person_name varchar(255),
        primary key (person_id)
    ) engine=MyISAM
Hibernate: 
    select
        max(ids_.mx) 
    from
        ( select
            max(person_id) as mx 
        from
            person_Table_Per_SubClass_tab 
        union
        select
            max(person_id) as mx 
        from
            EMPLOYEE_JOINED_SUB_01 
        union
        select
            max(person_id) as mx 
        from
            CONTRACT_EMPLOYEE_JOINED_SUB_02 
    ) ids_
Hibernate: 
    insert 
    into
        person_Table_Per_SubClass_tab
        (person_name, person_id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        EMPLOYEE_JOINED_SUB_01
        (person_name, designation, address, salary, person_id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        CONTRACT_EMPLOYEE_JOINED_SUB_02
        (person_name, location, contract_period, person_id) 
    values
        (?, ?, ?, ?)
Successfully saved Person Object.......!
     
 ==================================================Summary  :: Inheritance Mapping===================================
    Type                                                    TPCH                                                 TPSC                                                                TPCC 
                                   
•   XML                                                <subclass>                                      <joined-subclass>                                        <union-subclass>
                                                               <discriminator>                                  <key column="">
                                                                                                                            </ joined-subclass>    
• Annotation                     @Inheritance(                                                  @Inheritance(                                          @Inheritance(  
                                                            strategy=                                                             strategy=                                     strategy=                                                                                 
                                                  InheritanceType.SINGLE_TABLE                     InheritanceType.JOINED                                InheritanceType.TABLE_PER_CLASS                                                                                                           
                                                  )                                                                              )                                                                ) 
                                               @DiscriminatorColumn(........)                   @PrimaryKeyJoinColumn(...........)         @AttributeOverrides          
                                               @DiscriminatorValue(..........)                                                                                              @AttributeOverride
                                                @Polymorphism(.............)
•No of 
   Table                                                  1                                                                                  1+, ( Ex :3)                                        1+, ( Ex :3)
 Creation
  
• Analaysis                                        Duplication of columns                      No Duplicate columns                      No Duplicate columns,                                                                                                                                                                                                                                                                                                                                                   
                                                                                                                             but one-to-one relationship             no relation ship, but
                                                                                                                                                                                               parent table columns are child tables    
          
                          
