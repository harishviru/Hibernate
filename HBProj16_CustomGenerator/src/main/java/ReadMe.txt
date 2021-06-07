 =====================CustomGenerator==============================
 •custom generator must implements  IdentifierGenerator(I) to generated Id value
 
 
 1)IN XML
 
       <!--  CustomGenerator-->
	                     <id name="prodId"  column="product_id" type="java.lang.Integer">
		                       <generator class="com.har.generator.MyCustomRandGenerator" />
	                    </id>
	                    
2)IN Annotations	        

@Id
    @GenericGenerator(
        name = "myCustGen",
        strategy = "com.har.generator.MyCustomRandGenerator"
    )
    @GeneratedValue(generator = "myCustGen")
    @Column(name = "product_id", nullable = false)
    private Integer prodId;            