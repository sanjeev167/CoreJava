/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class DeadLockTestOfCandD {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedPrinter printer=new SharedPrinter();
		SharedScanner scanner=new SharedScanner();
		
		ThreadC c=new ThreadC(printer,scanner);
		Thread t1=new Thread(c,"Thread C");
		t1.start();
		
		ThreadD d=new ThreadD(printer,scanner);
		Thread t2=new Thread(d,"Thread D");
        t2.start();
	}

}
