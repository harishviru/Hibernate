                ===============For Server Managed Conn Pool===============
                
   1) In Hibernate cfg file 
                    
                                    <property name="connection.provider_class">org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl</property>
                                   <property name="connection.datasource">java:/comp/env/DsJndi</property>             
                                   
    2)DsJndi is datasource that can be defined in server context.xml like below
    
    
    <Resource name="DsJndi" 
      auth="Container" 
      type="javax.sql.DataSource" 
      driverClassName="com.mysql.cj.jdbc.Driver" 
      url="jdbc:mysql://localhost:3306/HBWalkOne" 
      username="root" 
      password="root" 
      
      maxActive="100" 
      maxIdle="20" 
      minIdle="5" 
      maxWait="10000">
      </Resource>
                               