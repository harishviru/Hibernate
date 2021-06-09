package com.har.cust.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

//Custom  service with ApacheDBCP2
public class ApacheDBCP2ConnectionProviderService implements ConnectionProvider {
	
	
	public ApacheDBCP2ConnectionProviderService() {
		System.out.println("ApacheDBCP2ConnectionProviderService.0-param constructor......!");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("ApacheDBCP2ConnectionProviderService.getConnection()");
		// create apache DBCp2  DataSource obj pointing to  jdbc con pool
		BasicDataSource  dataSource =new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/HBWalk");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dataSource.setMaxTotal(20); 
		dataSource.setMinIdle(5);
		dataSource.setMaxWaitMillis(20);
		//get pooled jdbc connection object
		Connection connection = dataSource.getConnection();
		return connection;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
