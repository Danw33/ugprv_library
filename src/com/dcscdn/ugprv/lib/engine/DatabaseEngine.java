/**
 * 
 */
package com.dcscdn.ugprv.lib.engine;

import java.beans.PropertyVetoException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.mchange.v2.c3p0.*;
import com.dcscdn.ugprv.lib.system.Trace;


/**
 * Database Engine
 *  - Handles Database connections while providing a pooled DataSource.
 * </br></br>
 * Used by methods requiring database access, the class makes use of the powerful MChange c3p0 library,
 * providing enterprise-ready JDBC3/4 connections with transparent pooling with support for prepared statements
 * and optionally binding to JNDI naming services.
 * 
 * @author Daniel Wilson
 */
public class DatabaseEngine {
	
	/**
	 * The Combo Pooled Data Source for this instance.
	 * Set up in the class constructor.
	 * @author Daniel Wilson
	 */
	public ComboPooledDataSource DataSource = new ComboPooledDataSource();
	
	public String LogStrings;// = new String("");
	
	/**
	 * 
	 */
	public PrintWriter LogStream;
	
	
	
	/**
	 * JDBC Driver Classes.
	 * Enumerates driver classes for supported JDBC datasource types.
	 * Each enumeration is mapped to a string representing the driver class.
	 * @author Daniel Wilson
	 */

	public enum DriverClass
	{
		/**
		 * Oracle Database.
		 * Supports Oracle OCI 9i and newer.
		 */
		ORACLE 		("oracle.jdbc.driver.OracleDriver"),
		
		/**
		 * PostgreSQL Database.
		 * Supports PostgreSQL v7.0 and newer.
		 */
		POSTGRESQL 	("org.postgresql.Driver"),
		
		/**
		 * Microsoft SQL Server (MS-SQL) Database.
		 * Supports Microsoft SQL Server 2000 and newer.
		 */
		MSSQL 		("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
		
		/**
		 * MySQL Database.
		 * Supports MySQL 5.0 and newer, using the modern MySQL Connector/J.
		 */
		MYSQL 		("com.mysql.jdbc.Driver");
		
		private final String ClassName;
		
		DriverClass(String jdbcClass) {

			ClassName = jdbcClass;
		}
		
		/**
		 * Get JDBC Driver Class Name.
		 * @return The full class name of the selected JDBC driver
		 */
		protected final String getClassName()
		{
			return ClassName;
		}
	}
	
	/**
	 * Database Engine Constructor.
	 * Opens a pooled datasource-based connection to the given database upon construction of the class instance.
	 * 
	 * @param Driver The {@code DriverClass} to use as the JDBC Driver
	 * @param User The Username to authenticate to the database
	 * @param Password The Password (in plaintext) for the given {@code User}
	 * @param ConnectionString A JDBC-URL for establishing the connection   jdbc:{@code driver}://{@code host}:{@code port}/{@code database}
	 * @author Daniel Wilson
	 * @see DriverClass List of supported Drivers
	 */
	public DatabaseEngine( DriverClass Driver, String User, String Password, String ConnectionString) {
		super();
		
		//Set the logging stream
		try {
			DataSource.setLogWriter( LogStream );
		} catch (SQLException e1) {
			Trace.Warn( e1, "Failed to attach Database Log Writer! Error: " + e1.getMessage() );
		}
		
		//Load JDBC Driver (Old Style)
		try //and load the selected JDBC driver if it isn't already pre-loaded as a library:
		{ 
			DataSource.setDriverClass( Driver.getClassName() );
		}
		catch ( PropertyVetoException e ) 
		{
			Trace.Fatal( e, "Failed to load JDBC Driver! Error: " + e.getMessage() );
		} 
		
		//Set the Connection String (JDBC URL) and Credentials
		DataSource.setJdbcUrl( ConnectionString ); 
		DataSource.setUser( User ); 
		DataSource.setPassword( Password ); 
		
		//Set some default connection pooling values (optional, will use c3p0 defaults if removed)
		DataSource.setMinPoolSize(8); 		//A Minimum of 8 for speedy burst capacity
		DataSource.setAcquireIncrement(4);  
		DataSource.setMaxPoolSize(64);		//A Maximum of 64 (8 times as much as minimum, not sure why! :')  )

	}
	
	/**
	 * Database Engine Constructor.
	 * Opens a pooled datasource-based connection to the given database upon construction of the class instance.
	 * 
	 * This empty constructor stub allows for null-valued new statements
	 * 
	 * @author Daniel Wilson
	 * @see DriverClass List of supported Drivers
	 */
	public DatabaseEngine(){};
	
	/**
	 * Database Engine Improvised Class-Destructor.
	 * Cleans up the DataSource and closes connections.
	 * Should be called when the DataSource is finished with for good (E.g: On Exit)
	 * @author Daniel Wilson
	 */
	public void Destruct() 
	{  
		DataSource.close(); 
	}

}
