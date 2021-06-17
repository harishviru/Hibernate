==========================One-To-Many<==Bi-dir==>Many-to-One==============================

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

In XML ::

Owner.hbm.xml
----------------------------
<set name="vehicles"   cascade="all"  lazy="extra"  inverse="true">
            <key column="owner_id"/>
            <one-to-many  class="com.har.domains.Vehicle"  />
 </set>

Vehicle.hbm.xml
----------------------------
         <many-to-one name="owner" column="owner_id"  class="com.har.domains.Owner"  cascade="all"  />



mappedBy::
=========

Note ::
   •The association may be bidirectional. In a bidirectional relationship ,
     one side (and only one) has to be the owner ,the owner is  responsible for the association column(s) update.
 • To declare a  side as not responsible for the relationship ,the attribute "mappedBy" is used. "mappedBy" refers to
    the property name of the association on the owner side.

   In Vehicle ::
     @ManyToOne
	 @JoinColumn(name="owner_id",referencedColumnName="owner_Id")
	 private  Owner  owner;  //To build many to One Association

  In Onwer ::
  
        //	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
       //	@JoinTable(name="own_vehicles",joinColumns={@JoinColumn(name="owner_id")},
         //	                   inverseJoinColumns={@JoinColumn(name="vehicle_Id")}
         //			)
	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="owner")
	private Set<Vehicle> vehicles;   //for One To Many Association //If mappedBy is there,then @JoinColumn,@JoinTable must not use,If mappedBy is there then propery (vehicle) entity is Onwer
	

Note :: If the collection is defined using generics to specify the element type, then the associated target entity
              type need not be specified ; otherwise the target entity class must be specified.
