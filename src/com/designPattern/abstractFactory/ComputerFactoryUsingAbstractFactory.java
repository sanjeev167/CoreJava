/**
 * 
 */
package com.designPattern.abstractFactory;

/**
 * @author Sanjeev
 * 
 * This final factory class is using abstract factory design pattern. It receives and instance of factory class through abstractFactory instance reference
 *
 */
public class ComputerFactoryUsingAbstractFactory {
	
	
	//
	public static Computer getComputerUsingFactory(ComputerAbstractFactory computerAbstractFactory) {
		Computer computer=null;	
		//Here, computerAbstractFactory may be any computerFactory i.e. it may be PcFactory or ServerFactory objects
		computer=computerAbstractFactory.createComputer();	    
	    return computer;			
	}
}
