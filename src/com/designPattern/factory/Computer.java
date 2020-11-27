/**
 * 
 */
package com.designPattern.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjeev
 *
 *This is a supper class which will be implemented by different computer device like PC, Server and laptop
 */
public abstract class Computer {
	
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	public abstract List<ComputerItem> getComputerItemsFromRepository();
	
	
	//Wheneve toString method will be called on an object with computer refrence, this toString method will be called.
	public String toString() {		
		return "RAM ="+this.getRAM()+" HDD ="+this.getHDD()+" CPU ="+this.getCPU()+"\n Available Items :-- \n"+
	                    getComputerItemsFromRepository();
	        		                                   
		
	}

}
