==============================================Hibernate Generators==============================================
[Hibernate Generators]
================
•  Generator classes are used to generate the 'identifier' for a persistent object,while saving an object into the database.
•  All Generator classes has to implement 'org.hibernate.id.IdentifierGenerator' interface.we have override generate()
    method .These method is responsible to generate 'identifier' value;
• To configure generator class we can use <generator/> tag  ,which is sub element of <id/> tag .
    The <generator/> tag has one attribute called "class"  which can be used to specify generator class-name.

•While configuring <generator/> tag in mapping file,if we need to pass any parameters to generator class then
      we can use <param/> tag,which is the sub element of <generator/> tag.

       Syntax ::
                         <hibernate-mapping>
                                          <class name="fully qualified name" table="table_name">
                                                         <id name="identifierVariableName" column="columnName">
                                                                                <generator class="generator-class-name">
                                                                                      <param name="param-name">param-value</param>
                                                                                </generator>
                                                          </id>


The following are the list of main generator we are  using in the hibernate framework
                                         1)Assigned
                                         2)Increment 
                                         3)sequence
                                         4)identity
                                         5)hilo
                                         6)native
                                         7)foreign
                                         8)uuid
                              

#1)Assigned        :: org.hibernate.id.Assigned
=========
• It is default id generator class
• If generator is "assigned" then the programmer has to assign the id for an object ,if not hibernate throw exception
• Assigned is a database independent generator class.
                          Ex :
                                  <id name="variablename" column="column_name"/>
                                                     Or
                                    <id name="variablename" column="column_name">
                                              <generator class="assigned"/>
                                     </id>
                                                         Or
                                                @Id


#2)Increment    ::       org.hibernate.id.IncrementGenerator
==========
• The generator supports in all databases,so it is database independent generator class.
• This generator class uses max(id) in DB + 1 formula for generating the id value for the new record ,before saving into       databse 
• If there is no record initially in the database,then for the first time this will save PK Value as 1.

                                            ex ::
                                                    <id name="variablename" column="column_name">
                                                            <generator class="increment"/>
                                                    </id>     
                                                                 Or
                                                           @Id
                                                            @GeneratedValue(strategy=GenerationType.AUTO)
         

#3)sequence         :: org.hibernate.id.SequenceGenerator
=========
• This generator class is database dependent ,it means we cannot use this generator clas for all databses.
•  It is  not supporting by MYSQL db. [supports in Oracle..etc]
•  If we add generator class as sequence then we need to configure a parameter under <generator/>
   tag  called sequence. For this parameter we need to pass sequence name.

Note : If we don't configure ,hibernate create default sequence called as "hibernate_sequence" by using hbm2ddl.auto

For ex :
           SQL> create sequence empn_sequence start with 1 increment by 1;
            SQL> sequence created

                                            <id name="variablename" column="column_name">
                                                            <generator class="sequence">
                                                                           <param name="sequence">sequence_name</param>
                                                             </generator>
                                                    </id>     
                                                          Or
                                                        @Id
                                                         @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator_name")
                                                          @SequenceGenerator(name="generator_name",sequenceName="sequence_name")
     

#4)identity               :: org.hibernate.id.IdentityGenerator
========
• This is database dependent,actually it is not work on oracle.
• Identity columns are supports by DB2,MYSQL,SQLSERVER...etc
• This identity generator doesn't needs any parameters to pass.

                         SQL>CREATE TABLE Employe(
                                    empno INT(10) NOT NULL AUTO INCREMENT,
                                      .............
                                     Primary key (empno)
                                       )
                                    
                                        <id name="variablename" column="column_name">
                                                            <generator class="identity"/>
                                            </id>  
                         
                                                        Or
                                             @Id
                                           @GeneratedValue(strategy=GenerationType.IDENTITY)


#5)hilo                            :: TableHiloGenerator 
=====
• This generator class generates id for an object when first time as one (1),From second time onwards,the id will
    be generated using max_lo+next_hi+next_hi.

•  When hilo generator is configured for <id/> tag then hibernate excepts three parameters configures along with hilo generator
                                                                 1) Table
                                                                 2)Column
                                                                 3)Max_lo

• When parameters are not configured,then hibernate consider default values are..
                                                                 1) Table                    : hibernate_unique_key
                                                                 2)Column                 :next_hi
                                                                 3)Max_lo                   :32767                             

•                                   Hilo generator formula :  max_lo * next_hi +next_hi 

• ex :#1   
       <id name="studentId" column="sid">
                 <generator class="hilo"/>
        </id>
                
          #2
          <id name="studentId" column="sid">
                   <generator class="hilo">
                          <param name="max_lo">10</param>
                   </generator>
           </id>
              
             #3
               <id name="studentId" column="sid">
                          <generator class="hilo">
                                  <param name="table">mytable</param>
                                   <param name="column">col1</param>
                                    <param name="max_lo">10</param>
                           </generator>
                  </id>



#6)native
========
• native doesn't have a separate generator class. It just uses other generator classes. 
                                                                                                                                      identity,
                                                                                                                                      sequence,
                                                                                                                                      hilo


 • First it will check whether the database supports identity or not.
 • If database not support identity then it will go for sequence.
 • If database not support sequence then it will go for hilo.

       ex : 
                                            <id name="variablename" column="column_name">
                                                            <generator class="native"/>
                                            </id>
                                                Or
                                            @Id
                                            @GeneratedValue(strategy=GenerationType.AUTO)


  #7)foreign             :: org.hibernate.id.ForeignGenerator
 ========
• The ForeignGenerator is  database independent
• The ForeignGenerator is only applicable for one-one relationship.
• The ForeignGenerator class returns the id of the parent object as the id for the child object.
                      
                        <id name="studentId" column="sid">
                              <generator class="foreign" />
                         </id>

#8)uuid                      :: org.hibernate.id.AbstractUUIDGenerator (Universal uniqueId)
======
• All the above generators classes are applicable for number type of PK  column of table.
•PK  column of table is a string type we can use  either assigned Or uuid.hex has a generator class.
•uuid generator generates a string of 32 characters length based on the following four values:

    1) IP Address of the machine
    2)Start-up time of JVM
    3)System time
    4)Counter value in JVM

            <id name="studentId" column="sid">
                          <generator class="uuid" />
           </id>


   ==================================Annotations===================================================

     1)  AUTO                       : Hibernate selects the generation strategy based on the used dialect.
     2)  IDENTITY               : Hibernate relies on an auto-incremented database column to generate the primary key,
     3)SEQUENCE              : Hibernate requests the primary key value from a database sequence.
     4)TABLE                        : Hibernate uses a database table to simulate a sequence.


1)  AUTO  

//Default Developer must have to supply id value
	/* @Id
	 @Column(name="product_id")
	private Integer prodId;*/
	 
	 
	//GenerationType.AUTO
	/* @Id
	 @GeneratedValue                    // ==== equal ==@GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="product_id")
	private Integer prodId;*/
	 
	 
  2)  IDENTITY 
	// GenerationType.IDENTITY
	/* @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)                 
	 @Column(name="product_id")
	private Integer prodId;*/

  3)SEQUENCE 	
	  //#01 :GenerationType.SEQUENCE    
	//Actually SEQUENECE Works in Oracle but  not in MYSQL ,becoz Hibernate uses TABLE SEQUENCE In MYSQL
	///Here Hibernate create default sequence
	/*@Id
	 @GeneratedValue (strategy= GenerationType.SEQUENCE)
	 @Column(name="product_id")
	 private Integer prodId;*/
	
	
	  //#02 :GenerationType.SEQUENCE   
	   //Actually SEQUENECE Works in Oracle but  not in MYSQL ,becoz Hibernate uses TABLE SEQUENCE In MYSQL
	   ///Here We are assigning the our table sequence
	/*	 @Id
		 @GeneratedValue (strategy= GenerationType.SEQUENCE,generator="prodSeqGen")
		@SequenceGenerator(name = "prodSeqGen", sequenceName = "product_sequence")
		 @Column(name="product_id")
		 private Integer prodId;*/

 4)TABLE  		
	///#01.Here Hibernate create default Table  for Id generation
	/*@Id
	@GeneratedValue (strategy= GenerationType.TABLE)
	@Column(name="product_id")
	private Integer prodId;*/
	
	///#02.Here Hibernate uses assinged Table 
	@Id
	@GeneratedValue (strategy= GenerationType.TABLE,generator="prodTableGen")
	@TableGenerator(name = "prodTableGen", table = "product_sequence")
	@Column(name="product_id")
	private Integer prodId;