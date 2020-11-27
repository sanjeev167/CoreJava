/**
 * 
 */
package com.designPattern.singleton;

/**
 * @author Sanjeev
 *
 */
public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnection databaseConnection=DatabaseConnection.getDatabaseConnection();
		for (int i=0;i<5;i++)
		System.out.println("Object HashCode = "+databaseConnection.hashCode());

	}

}
