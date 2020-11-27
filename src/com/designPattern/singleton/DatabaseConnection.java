/**
 * 
 */
package com.designPattern.singleton;

/**
 * @author Sanjeev
 * 
 * 
 * This is an example of singleton design pattern. The object this class will be created through the public getDatabaseConnection()
 * method.
 * 
 * 
 * 
 */
public class DatabaseConnection {
	
	private static DatabaseConnection databaseConnection=null;
	private DatabaseConnection() {}
	
	public static DatabaseConnection getDatabaseConnection() {
		
		if (databaseConnection==null)
			databaseConnection=new DatabaseConnection();		
		return databaseConnection;
	}

}
