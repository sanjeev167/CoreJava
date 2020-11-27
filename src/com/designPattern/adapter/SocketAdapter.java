/**
 * 
 */
package com.designPattern.adapter;

/**
 * @author Sanjeev
 *
 *
 *This is an interface which will be implemented by SocketAdapter class
 */
public interface SocketAdapter {

	public Volt get120Volt(); //This will be used for getting 120 volt output as volt object
		
	public Volt get12Volt();//This will be used for getting 12 volt output as volt object
	
	public Volt get3Volt();//This will be used for getting 3 volt output as volt object
}