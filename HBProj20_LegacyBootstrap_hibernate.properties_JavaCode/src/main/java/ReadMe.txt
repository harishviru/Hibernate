Legacy Approachs
                       #01 :: By using hibernate.properties
-----------------------------------------------------------------------------------------
 #connection properties
hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
hibernate.connection.url=jdbc:mysql://localhost:3306/HBWalk
hibernate.connection.username=root
hibernate.connection.password=root

#hibernate properties
hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
hibernate.format_sql=true

Legacy Approach #02 :: Programmatic Approach
                              By adding keys and values to configuration object [By java code]
  --------------------------------------------------------------------------------------------------------------------------------------------------
            //Boot strapping the hibernate
			 Configuration cfg      =  new Configuration();
			
			 //add connection properties to cfg
			 cfg.setProperty(AvailableSettings.DRIVER,"com.mysql.cj.jdbc.Driver");
			 cfg.setProperty(AvailableSettings.URL,"jdbc:mysql://localhost:3306/HBWalk");
			 cfg.setProperty(AvailableSettings.USER,"root");
			 cfg.setProperty(AvailableSettings.PASS,"root");
			 
			 //hibernate optional props
			 cfg.setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			 cfg.setProperty(AvailableSettings.HBM2DDL_AUTO,"update");
			 cfg.setProperty(AvailableSettings.SHOW_SQL,"true");
			 cfg.setProperty(AvailableSettings.FORMAT_SQL,"true");

			 //add Mapping file
			 cfg.addFile("src/main/java/com/har/entity/Student.hbm.xml");
			//cfg.addAnnotatedClass(Student.class);
				
			// create  HB SessionFactory object
			sessionFactory = cfg.buildSessionFactory();                            