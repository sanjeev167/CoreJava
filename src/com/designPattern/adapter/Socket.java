/**
 * 
 */
package com.designPattern.adapter;

/**
 * @author Sanjeev
 *
 *
 *This will be used for creating a socket object
 */
public class Socket {

	public Volt getVolt(){//This is used for getting direct 120 volt output
		return new Volt(120);
	}
}

