/**
 * 
 */
package com.designPattern.abstractFactory;

/**
 * @author Sanjeev
 *
 */
public class PCFactory implements ComputerAbstractFactory{
	private String ram;
	private String hdd;
	private String cpu;
	
	public PCFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new PC(ram,hdd,cpu);//ram , hdd and cpu have already been initialized through PCFactory constructor while calling this factory through abstract factory
	}

}
