 Hibernate Supported Identified Generators ::
 ====================================
• To Integrate hibernate specific generators into JPA we can use either
                      i)@org.hibernate.annotations.GenericGenerator   (Or)
                      ii)@org.hibernate.annotations.GenericGenerators

#01  :  assigned (org.hibernate.id.Assigned)

   @Id
    @GenericGenerator(name="myGenerator",strategy="assigned")
    @GeneratedValue(name="myGenerator")
    @Column(name="product_id")
    private Integer productId;

#02  :  increment (org.hibernate.id.IncrementGenerator)

   @Id
    @GenericGenerator(name="myGenerator",strategy="increment")
    @GeneratedValue(name="myGenerator")
    @Column(name="product_id")
    private Integer productId;

 
#03  :  sequence (org.hibernate.id.SequenceGenerator)

   @Id
    @GenericGenerator(name="myGenerator",strategy="sequence")
    @GeneratedValue(name="myGenerator")
    @Column(name="product_id")
    private Integer productId;             

Note ::if there no parameters in @GenericGenerator ,Hibernate create default sequence name(hibernate_sequence)

  @Id
    @GenericGenerator(name="myGenerator",strategy="sequence",
       parameters={@Parameter(name="sequence",value="product_sequence")})
    @GeneratedValue(name="myGenerator")
    @Column(name="product_id")
    private Integer productId;   


Note ::Here parameters  are there in @GenericGenerator ,Hibernate create  sequence name with(product_sequence)


#04  :  custom (pkg.OurOwnGenerator)

    @Id
    @GenericGenerator(name="myGenerator",strategy="pkg.OurOwnGenerator")
    @GeneratedValue(name="myGenerator")
    @Column(name="product_id")
    private Integer productId;