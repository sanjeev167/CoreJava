/**
 * 
 */
package com.MultiThreading;

/**
 * @author Sanjeev
 *
 */
public class MultithreadingDemo extends Thread{
	
	public void run() {
		System.out.println("MultithreadingDemo is running ");
	}

	public static void main(String [] args) {		
		MultithreadingDemo obj=new MultithreadingDemo();//Thread is in new state
		//Now thread will be started
		obj.start();//Goes in runnijng state.	
	}
}
