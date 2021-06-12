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
                          

  #ii)Table Per Subclass  [TPSC] ::
  -----------------------------------------           
• In this approach,every class of inheritance hierarchy contains its own database table.
• But the table of Sub class will maintain one-to-one relationship with table of Super class.
• To configure super class we can use <class> tag and to configure sub class we can use 
                                                      <joined-subclass> tags in Hibernate mapping file.
•  It uses the Primary key and foreign key relation.
•  In Annotation we can use  @Inheritance(strategy=InheritacneType.Joined) ,@PrimaryKeyJoinColumn(name="Fk_col_name")

  Ex ::
               In XML ::
               -----------
               <joined-subclass name="pkg.className" table="table_name">
                <key column="fk_column_name"/>   <!--FK Column is to build the association---->
                 ............properties--------
              </joined-subclass>

                In Anno 
                -----------
 In Parent Class ::

 • @Inheritance(strategy=InheritanceType.Joined)                                     
                                                
  In Child#01 ::
  
 • @Entity
    @PrimaryKeyJoinColumn(name="Fk_col_name")
                                   
 In Child#02 ::
  
 • @Entity
     @PrimaryKeyJoinColumn(name="Fk_col_name")                        
     
     
     Ex ::  In XML ::
      
          <class name="pk.superclass" table="super_table_01">
           <id name="personId" column="person_id" type="java.lang.Integer">
                            <generator class="increment"/>
                  </id>         
         
          <!-- joining subclass #01 -->
          <joined-subclass name="pkg.subclass01" table="child_table_01">
                    <key column="foreign_column_name"/> <!-- FK Column is to build association with super class Person -->
                      ............................Properties........................................
          </joined-subclass>
          
          <!-- subclass #02 -->
               <joined-subclass name="pkg.subclass02" table="child_table_02">
                    <key column="foreign_column_name"/> <!-- FK Column is to build association with super class Person -->
                      ............................Properties........................................
          </joined-subclass>
         </class> 
     
         iN Anno ::
         ----------------
            
            In Super Class ::
            ---------------------------  
             @Data
            @Entity
            @Table(name="person_tab")
            @Inheritance(strategy=InheritanceType.JOINED)   
         
             
            In Child Class#01 ::
            ---------------------------  
            @PrimaryKeyJoinColumn(name="person_Emp_Id")
            
            In Child Class#01 ::
            ---------------------------  
           @PrimaryKeyJoinColumn(name="person_CEmp_Id")
     
     
     output ::
     ---------------
     
     Hibernate: 
    
    create table CONTRACT_EMPLOYEE_JOINED_SUB_02 (
       person_CEmp_Id integer not null,
        location varchar(255),
        contract_period float,
        primary key (person_CEmp_Id)
    ) engine=MyISAM
Hibernate: 
    
    create table EMPLOYEE_JOINED_SUB_01 (
       person_Emp_Id integer not null,
        designation varchar(255),
        address varchar(255),
        salary double precision,
        primary key (person_Emp_Id)
    ) engine=MyISAM
Hibernate: 
    
    create table person_Table_Per_SubClass_tab (
       person_id integer not null,
        person_name varchar(255),
        primary key (person_id)
    ) engine=MyISAM
Hibernate: 
    
    alter table CONTRACT_EMPLOYEE_JOINED_SUB_02 
       add constraint FKd2f8u6clecgepxaklhr73p6mr 
       foreign key (person_Cemp_Id) 
       references person_Table_Per_SubClass_tab (person_id)
Hibernate: 
    
    alter table EMPLOYEE_JOINED_SUB_01 
       add constraint FKr7poyvcsn6ckvouxqiv1o1nof 
       foreign key (person_emp_Id) 
       references person_Table_Per_SubClass_tab (person_id)

Hibernate: 
    select
        max(person_id) 
    from
        person_Table_Per_SubClass_tab
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
        person_Table_Per_SubClass_tab
        (person_name, person_id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        EMPLOYEE_JOINED_SUB_1
        (designation, address, salary, person_Emp_Id) 
    values
        (?, ?, ?, ?)
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
        CONTRACT_EMPLOYEE_JOINED_SUB_2
        (location, contract_period, person_CEmp_Id) 
    values
        (?, ?, ?)
Successfully saved Person Object.......!

     
     
     
     
     
     
     