/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class DeadLockTestOfEandF {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedPrinterNew printer=new SharedPrinterNew();
		SharedScannerNew scanner=new SharedScannerNew();
		
		ThreadE e=new ThreadE(printer,scanner);
		Thread t1=new Thread(e,"Thread E");
		t1.start();
		
		ThreadF f=new ThreadF(printer,scanner);
		Thread t2=new Thread(f,"Thread F");
        t2.start();
	}

}
