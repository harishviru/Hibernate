
#ConnectionPools::
=============
•C3PO            :: Default If jar is available in classpath
•Proxool
•Hikari
•Server Managed Connection Pool


#01 :C3PO                            :: Default If jar is available in classpath or if don't provider , connection.provider_class value,
=========
       <dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-c3p0</artifactId>
		<version>5.4.3.Final</version>
	</dependency>


•c3p0 connection pooling specific settings

1)	String CONNECTION_PROVIDER ="hibernate.connection.provider_class"; -->an instance of ConnectionProvider
2)String C3P0_CONFIG_PREFIX = "hibernate.c3p0";                                              --> A setting prefix used to indicate settings that target the hibernate-c3p0 integration
3)String C3P0_MAX_SIZE = "hibernate.c3p0.max_size";                                      -->Maximum size of C3P0 connection pool
4)String C3P0_MIN_SIZE = "hibernate.c3p0.min_size";                                       --> Minimum size of C3P0 connection pool
5)String C3P0_TIMEOUT = "hibernate.c3p0.timeout";                                        --->Maximum idle time for C3P0 connection pool
6)String C3P0_MAX_STATEMENTS = "hibernate.c3p0.max_statements";      -->Maximum size of C3P0 statement cache
7)String C3P0_ACQUIRE_INCREMENT = "hibernate.c3p0.acquire_increment";->Number of connections acquired when pool is exhausted
8)String C3P0_IDLE_TEST_PERIOD = "hibernate.c3p0.idle_test_period";       -->Idle time before a C3P0 pooled connection is validated

                                       Ex :: 
                                            <!--  Connection provider to work with C3P0   #01:hibernate-c3p0 -->
                                              <property name="hibernate.connection.provider_class">org.hibernate.c3p0.internal.C3P0ConnectionProvider</property>
                         
                                             <!-- Conn properties -->
                                                <property name="hibernate.c3p0.min_size">10</property>
                                               <property name="hibernate.c3p0.max_size">100</property>
                                                <property name="hibernate.c3p0.timeout">100</property>
                                                <property name="hibernate.c3p0.max_statements">50</property>
                                                <property name="hibernate.c3p0.idle_test_period">1000</property>
                                                
      Note ::
      if don't provider , connection.provider_class value,the it take C3PO connections if jar is available in classpath
                                                
 #02 :: Proxool
 ===========
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-proxool</artifactId>
	<version>5.4.3.Final</version>
</dependency>
        
• proxool connection pooling specific settings                                               
 1)	String CONNECTION_PROVIDER ="hibernate.connection.provider_class"; -->an instance of ConnectionProvider
2)String PROXOOL_CONFIG_PREFIX = "hibernate.proxool";                              ---> A setting prefix used to indicate settings that target the hibernate-proxool integration
3)String PROXOOL_XML = "hibernate.proxool.xml";                                          --->Proxool property to configure the Proxool Provider using an XML (<tt>/path/to/file.xml</tt>)
4)String PROXOOL_PROPERTIES = "hibernate.proxool.properties";               --->Proxool property to configure the Proxool Provider  using a properties file (<tt>/path/to/proxool.properties</tt>)
5)String PROXOOL_EXISTING_POOL = "hibernate.proxool.existing_pool";    --->Proxool property to configure the Proxool Provider from an already existing pool (<tt>true</tt> / <tt>false</tt>)
6)String PROXOOL_POOL_ALIAS = "hibernate.proxool.pool_alias";                ---->proxool property with the Proxool pool alias to use                                     
                                                
                
                Ex ::
                                                     <!-- Connection provider to work with Proxool  #02:hibernate-proxool -->
                                                  <property name="connection.provider_class">org.hibernate.proxool.internal.ProxoolConnectionProvider</property>
      
                                                  <!-- Proxool properites -->  
                                                 <property name="hibernate.proxool.pool_alias">proxyPool</property>
                                                  <property name="hibernate.proxool.xml">com/har/cfgs/proxool.xml</property>
      
   proxool.xml
   ----------------------                                               
      <proxool-config>
    <proxool>
        <alias>proxyPool</alias>
        <driver-url>jdbc:mysql://localhost:3306/HBWalkOne</driver-url>
        <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
        <driver-properties>
            <property name="user" value="root"></property>
            <property name="password" value="root"></property>
        </driver-properties>
         
        <minimum-connection-count>10</minimum-connection-count>
        <maximum-connection-count>50</maximum-connection-count>
    </proxool>
 </proxool-config>
                
                                                
  #03: Hikari
  ==========
  <!-- hibernate-hikaricp -->
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-hikaricp</artifactId>
	<version>5.4.3.Final</version>
</dependency>                                              
         
         
   1)	String CONNECTION_PROVIDER ="hibernate.connection.provider_class"; -->an instance of ConnectionProvider
  
                                                <!-- Connection provider to work with Hikari -#03.hibernate-hikaricp -->
                                                <property name="connection.provider_class">org.hibernate.hikaricp.internal.HikariCPConnectionProvider</property>

	                                                 <!-- HikariCP settings -->
	                                               <property name="hikari.connectionTimeout">50000</property>
	                                                <property name="hibernate.hikari.minimumIdle">10</property>
	                                                <property name="hibernate.hikari.maximumPoolSize">20</property>
	                                                  <property name="hibernate.hikari.idleTimeout">30000</property> 
  
  
  
  
  
  
  
  
  
  
  
                                                
                                                
                                                