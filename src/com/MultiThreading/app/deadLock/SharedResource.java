/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class SharedResource {
	
	
	public void getPrinter() {
		
		System.out.println("Printer");
	}
	
	public void getScanner() {

		System.out.println("Scanner");
	}

}
