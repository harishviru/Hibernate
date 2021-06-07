#1)uuid                      :: org.hibernate.id.AbstractUUIDGenerator (Universal uniqueId)
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

#2)guid
• same as the uuid algorithm.it is a database dependent
• It works on SQL server,and MYSQL
• It generates string based identity value

 <id name="studentId" column="sid">
                          <generator class="guid" />
           </id>

### Special Info

#Generate UUIDs with Hibernate
-----------------------------------------------

The IETF RFC 4122 defines 4 different strategies to generate UUIDs. Hibernate’s UUIDGenerator supports 2 of them:

   •  The default strategy generates the UUID based on random numbers (IETF RFC 4122 Version 4).
   • You can also configure a generator that uses the IP address of the machine and a timestamp (IETF RFC 4122 Version 1).


UUID
====
	
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "product_id", updatable = false, nullable = false)
    private UUID id;

GUID
====
    	
  
	@Id
    @GeneratedValue(generator = "GUID")
    @GenericGenerator(
        name = "GUID",
        strategy = "org.hibernate.id.GUIDGenerator"
    )
    @Column(name = "product_id", updatable = false, nullable = false)
    private String id;
	