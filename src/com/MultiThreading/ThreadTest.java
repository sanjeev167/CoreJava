/**
 * 
 */
package com.MultiThreading;

/**
 * @author Sanjeev
 *
 */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
		Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
		
		
		t1.start();
		
		t2.start();
		
		
		/*Thread t3 = new MyThread("t3");
		Thread t4 = new MyThread("t4");
		System.out.println("Starting MyThreads");
		t3.start();
		t4.start();
		System.out.println("MyThreads has been started");
        */
	}

}
