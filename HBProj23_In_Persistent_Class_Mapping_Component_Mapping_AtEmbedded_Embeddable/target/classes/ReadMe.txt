    ==========================================Persistent Class Mapping ===================================
•  Configurations in hibernate mapping file are called as Object Relational mapping configurations
  We can perform the following ORM configurations.......
                                     1)Basic ORM (basic example we can use <property> tag
                                     2)Component Mapping
                                     3)Inheritance Mapping
                                     4)Collection Mapping
  
• The property of hibernate persistence class that is mapped with a single column of database table is called
       as simple property
          Ex ::
                           <property name="empName" column="emp_name"/>


#02 :Component Mapping::
-----------------------------------------------
• The property (Object Type) of hibernate persistence class that is mapped with mutiple columns of database table is called 
    as component property .
• To use component mapping we can work with <component> tag.
                  
       Ex : In XML
                    <component name="address" class="com.har.pojo.Address">
                        <property name="propertyName1" column="column_name1"/>
                       <property name="propertyName2" column="column_name2"/>
                       <property name="propertyName3" column="column_name3"/>
                   </component>

                In Annotation ::
               In annotation we can use  @Embeddable  and @Embedded

•A component property holds represents multiple column values of a record. The data type of component property is always an
    user-defined data types.
• To configure simple property in hibernate mapping file we can use  <property> tag.Similarly to configure 
   component property in hibernate mapping use <component> tag.
    
  • Created Table structure  
    
   create table employee_tab (
       employee_id integer not null,
        emp_name varchar(255),
        designation varchar(255),
        salary double precision,
        house_no varchar(255),
        street varchar(255),
        city varchar(255),
        state varchar(255),
        primary key (employee_id)
    )