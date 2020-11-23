/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class SharedPrinterNew {
	
	
public synchronized void getPrinter() {
	
	System.out.println("\t\t "+Thread.currentThread().getName()+" has taken lock on Printer");	
	}
	
	
}
