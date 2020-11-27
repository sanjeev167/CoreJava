/**
 * 
 */
package com.designPattern.adapter;

/**
 * @author Sanjeev
 * 
 * It is used to get Volt object
 *
 */
public class Volt {

	private int volts;
	
	public Volt(int v){
		this.volts=v;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}
	
}
