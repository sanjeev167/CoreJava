/**
 * 
 */
package com.designPattern.factory;

/**
 * @author Sanjeev
 *
 */
public class FactoryDesignPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer computer = ComputerFactory.getComputerConfiguration("PC", "128 MB", "60 GB", "1.4 GHZ");

		System.out.println("PC Configuration: --> " + computer);

		computer = ComputerFactory.getComputerConfiguration("Server", "4 GB", "1 TB", "3.4 GHZ");
		
		System.out.println("\nServer Configuration : --> " + computer);

	}

}
