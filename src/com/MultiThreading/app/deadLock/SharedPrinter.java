/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class SharedPrinter {
	
	
public void getPrinter() {
	
	System.out.println("\t\t "+Thread.currentThread().getName()+" has taken lock on Printer");	
	}
	
	
}
