#Object Versioning
==============
•If we want to know how many no of times that an object is modified then we need to apply this versioning concept.
• Whenever we use versioning then hibernate inserts version number as zero (0) if object is saved for the 
   first time in database.
• Next time when we update this object ,hibernate increments that version number by one (1)  automatically.
• In hibernate mapping file,we can add an element like <version> oo @Version soon after id element .

    Ex ::
            <version name="property_name" column="column_name"/>


#Object Timestamping
==============
There are multiple ways to achieve it,they are

• database update trigger
• entity lifecycle event to update the timestamp attribute
• You can use an additional framework, like Hibernate Envers
•  You can use the Hibernate-specific @CreationTimestamp and
                                                                        @UpdateTimestamp annotations and 
      let Hibernate trigger the required updates.

Note : Here we are discussing @CreationTimestamp and @UpdateTimestamp 

@CreationTimestamp             :: Only In Insert statement
   • When a new entity gets persisted, Hibernate gets the current timestamp from the VM and sets it as the value of the attribute annotated

@UpdateTimestamp              ::Changed with every update statement
   • Hibernate gets the current timestamp from the VM and sets it as the update timestamp on the EVERY SQL Update statement.
      And also used for  new entity to persisting time.

In XML ::
                                                <timestamp name="lastUpdated" column="lastUpdated"/>


#Supported attribute types
===================
You can use the @CreationTimestamp and @UpdateTimestamp with the following attribute types:

    java.time.LocalDate (since Hibernate 5.2.3)
    java.time.LocalDateTime (since Hibernate 5.2.3)
    java.util.Date
    java.util.Calendar
    java.sql.Date
    java.sql.Time
    java.sql.Timestamp
