/**
 * 
 */
package com.designPattern.abstractFactory;

/**
 * @author Sanjeev
 *
 */
public class AbstractFactoryDesignPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer pc = ComputerFactoryUsingAbstractFactory.getComputerUsingFactory(new PCFactory("2 GB","500 GB","2.4 GHz"));
		Computer server = ComputerFactoryUsingAbstractFactory.getComputerUsingFactory(new ServerFactory("16 GB","1 TB","2.9 GHz"));
		
		System.out.println("AbstractFactory PC Config::"+pc);
		System.out.println("AbstractFactory Server Config::"+server);

	}

}
