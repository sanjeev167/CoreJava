/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class SharedScannerNew {
	
	public synchronized void getScanner() {
		System.out.println("\t\t "+Thread.currentThread().getName()+" has taken lock on Scanner");
	}
}
