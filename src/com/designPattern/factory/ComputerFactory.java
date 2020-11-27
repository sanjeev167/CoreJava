/**
 * 
 */
package com.designPattern.factory;

/**
 * @author Sanjeev
 *
 */
public class ComputerFactory {
	
	
	public static Computer getComputerConfiguration(String type, String ram, String hdd, String cpu) {
		Computer computer=null;
		
		if (type.equalsIgnoreCase("PC"))
			computer=new PC( ram,  hdd,  cpu);
	    if (type.equalsIgnoreCase("Server"))	
	    	computer=new Server( ram,  hdd,  cpu);
	    
	    return computer;			
	}
}
