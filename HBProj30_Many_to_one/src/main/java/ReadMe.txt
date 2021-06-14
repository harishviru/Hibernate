 2)many-to-one
 • This type of association relates many objects of an entity to one Object of another entity.

     Ex : In XML 
             ----------
              <many-to-one name="department" class="pkg.Department"     column="dept_no" cascade="all" ............../> 
  
                In Anno
                -----------
                @ManyToOne(targetEntity=Department.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER) // cascade="all"
	        @JoinColumn(name="department_id",referencedColumnName="department_Id")
	        
	  Output ::
	  ----------------
	  
	  Hibernate: 
    
    create table department (
       department_Id integer not null auto_increment,
        dname varchar(255),
        location varchar(255),
        primary key (department_Id)
    ) engine=MyISAM
Hibernate: 
    
    create table employee (
       employee_Id integer not null auto_increment,
        emp_name varchar(255),
        salary double precision,
        department_id integer,
        primary key (employee_Id)
    ) engine=MyISAM
Hibernate: 
    
    alter table employee 
       add constraint FKbejtwvg9bxus2mffsm3swj3u9 
       foreign key (department_id) 
       references department (department_Id)
Hibernate: 
    insert 
    into
        department
        (dname, location) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        employee
        (department_id, emp_name, salary) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        employee
        (department_id, emp_name, salary) 
    values
        (?, ?, ?)
Successfully saved object (child to parent)
	        